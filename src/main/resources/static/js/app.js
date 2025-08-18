document.addEventListener('DOMContentLoaded', async () => {
    try {
        // 1. Chargement parallèle des données
        const [countRes, amountRes, facturesRes] = await Promise.all([
            fetch('/api/v1/factures/retard/count'),
            fetch('/api/v1/factures/retard/montant-total'),
            fetch('/api/v1/factures/retard')
        ]);

        // Vérification des réponses
        if (!countRes.ok || !amountRes.ok || !facturesRes.ok) {
            throw new Error('Erreur API');
        }

        const count = await countRes.text();
        const amount = await amountRes.text();
        const factures = await facturesRes.json();

        // 2. Mise à jour de l'UI
        document.getElementById('factures-count').textContent = count;
        document.getElementById('montant-total').textContent =
            parseFloat(amount).toLocaleString('fr-FR') + ' DH';
        document.getElementById('factures-count-header').textContent = count;

        // 3. Rendu du tableau
        renderFacturesTable(factures);

    } catch (error) {
        handleLoadingError(error);
    }
});

// Fonction pour afficher le tableau des factures
function renderFacturesTable(factures) {
    const tbody = document.getElementById('factures-body');
    tbody.innerHTML = factures.map(facture => `
        <tr class="hover:bg-gray-50">
            <td class="px-6 py-4 whitespace-nowrap">${facture['N° Facture']}</td>
            <td class="px-6 py-4 whitespace-nowrap">${facture.Client}</td>
            <td class="px-6 py-4 whitespace-nowrap">${
        parseFloat(facture.Montant).toLocaleString('fr-FR')
    } DH</td>
            <td class="px-6 py-4 whitespace-nowrap">${
        formatDate(facture.Échéance)
    }</td>
            <td class="px-6 py-4 whitespace-nowrap">
                <span class="late-badge">${facture.Statut}</span>
            </td>
            <td class="px-6 py-4 whitespace-nowrap">${
        facture['Dernière tentative'] ?
            '📍 ' + formatDate(facture['Dernière tentative']) :
            'Aucune tentative'
    }</td>
            <td class="px-6 py-4 whitespace-nowrap">
                <button onclick="showTentativeModal('${facture['N° Facture']}', '${facture.Client}', '${
        parseFloat(facture.Montant).toLocaleString('fr-FR')} DH')" 
                        class="action-btn">
                    + Tentative
                </button>
            </td>
        </tr>
    `).join('');
}

// Helper pour formater les dates ISO
function formatDate(isoString) {
    if (!isoString) return 'N/A';
    try {
        const date = new Date(isoString);
        return date.toLocaleDateString('fr-FR');
    } catch {
        return isoString.split('T')[0];
    }
}

// Gestion des erreurs de chargement
function handleLoadingError(error) {
    console.error("Erreur:", error);
    document.getElementById('factures-count').textContent = "Erreur";
    document.getElementById('montant-total').textContent = "Erreur";
    document.getElementById('factures-body').innerHTML = `
        <tr>
            <td colspan="7" class="px-6 py-4 text-center text-red-600">
                Erreur de chargement - Voir la console (F12)
            </td>
        </tr>
    `;
}

// Fonction pour afficher le modal
window.showTentativeModal = (factureId, client, montant) => {
    const modal = document.getElementById('tentative-modal');
    document.getElementById('modal-facture-id').value = factureId;
    document.getElementById('modal-client').textContent = client;
    document.getElementById('modal-montant').textContent = montant;
    modal.classList.remove('hidden');
};

// Fonction pour envoyer les données (version optimisée)
window.addTentative = async () => {
    const modal = document.getElementById('tentative-modal');
    const btnSubmit = document.querySelector('#tentative-form button[type="button"]');

    try {
        // Désactiver le bouton pendant l'envoi
        btnSubmit.disabled = true;
        btnSubmit.textContent = 'Enregistrement...';

        // Récupération des valeurs
        const formData = {
            factureId: parseInt(document.getElementById('modal-facture-id').value),
            userId: 1, // À remplacer par l'ID utilisateur dynamique
            methode: document.getElementById('methode').value,
            statut: document.getElementById('statut').value
        };

        // Validation
        if (!formData.methode || !formData.statut) {
            throw new Error('Veuillez sélectionner une méthode et un statut');
        }

        // Envoi de la requête
        const response = await fetch('http://localhost:8080/api/v1/tentatives', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        });

        // Fermer le modal immédiatement
        modal.classList.add('hidden');

        if (!response.ok) {
            const error = await response.text();
            throw new Error(error || 'Erreur serveur');
        }

        // Rafraîchissement après un court délai
        setTimeout(() => {
            location.reload();
        }, 300);

    } catch (error) {
        console.error('Erreur:', error);
        alert('Échec: ' + error.message);
        modal.classList.remove('hidden');
    } finally {
        btnSubmit.disabled = false;
        btnSubmit.textContent = 'Enregistrer';
    }
};