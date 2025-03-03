create table utilsateur(
    id_user serial primary key,
    pseudo varchar(50),
    prenom varchar(50),
    nom varchar(50),
    mot_de_pass varchar(50)
)