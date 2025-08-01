INSERT INTO client (id, nom, email, tel, adresse) VALUES
(1, 'Clinique Al Amal', 'contact@alamal.ma', '0522431122', 'Casablanca'),
(2, 'Laboratoire MedLab', 'lab@medlab.ma', '0522548899', 'Rabat');

INSERT INTO utilisateur (id, username, password, role) VALUES
(1, 'admin', 'admin123', 'ADMIN'),
(2, 'amine', 'amine2024', 'AGENT');

INSERT INTO bande_livraison (id, date_livraison, client_id) VALUES
(1, '2025-06-01', 1),
(2, '2025-06-10', 2);

INSERT INTO bande_reception (id, date_reception, bande_livraison_id) VALUES
(1, '2025-06-02', 1),
(2, '2025-06-11', 2);

INSERT INTO facture (id, montant, date_emission, date_echeance, payee, bande_reception_id, client_id) VALUES
(1, 1200.50, '2025-06-03', '2025-07-01', false, 1, 1),
(2, 950.00, '2025-06-12', '2025-07-12', true, 2, 2);

INSERT INTO tentative_recouvrement (id, date, methode, statut, reponse_client, utilisateur_id, facture_id) VALUES
(1, '2025-07-02 10:00:00', 'EMAIL', 'ENVOYÉ', 'Pas de réponse', 1, 1),
(2, '2025-07-05 15:00:00', 'APPEL', 'RÉPONDU', 'Le client paiera cette semaine', 1, 1);
