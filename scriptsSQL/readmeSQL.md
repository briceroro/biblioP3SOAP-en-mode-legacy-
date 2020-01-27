### init de la BDD
Pas besoin de script pour initialiser la BDD, uniquement la crée et l'aisse le webService l'auto configurer lors de son lancement avec hibernate.

### Gestion du mot de passe utilisateur

Le mot de passe des utilisateurs test est :test123

Le choix a été fait que l'encodage bCript(via spring sécurity) soit fait avec l'application Admin non dévéllopé dans ce projet.
De ce fait a aucun moment le mot de passe n'est transmis en clair.

pour creer d'autres Mdp à des fins de test vous pouvez utiliser le dépôt :https://github.com/briceroro/passwordCodeur
