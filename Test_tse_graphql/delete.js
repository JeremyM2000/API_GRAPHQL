const { gql, request } = require('graphql-request')

function delete_all_player()
{
    const mutation = gql`
        mutation deleteAllPlayer {
            deleteAllPlayer {
                id
            }
        }
    `;

    // Supression de tous les joueurs
    request('http://localhost:8080/graphql', mutation)
        .then(response => {
            console.log('Liste des joueurs :', response.deleteAllPlayer);
        })
        .catch(error => {
            console.error('Erreur lors de la récupération des joueurs');
        });
};

function delete_one_player(id)
{
    const mutation = gql`
        mutation deleteOnePlayerById {
            deleteOnePlayerById(id: "`+id+`") {
                id
                firstName
                lastName
                position
                number
                club {
                  id
                  name
                  city
                  league
                }
            }
        }
    `;

    // Supression d'un club
    request('http://localhost:8080/graphql', mutation)
        .then(response => {
            console.log('Liste des joueurs :', response.deleteOnePlayerById);
        })
        .catch(error => {
            console.error('Erreur lors de la récupération des clubs');
        });
}

function delete_all_club()
{
    const mutation = gql`
        mutation DeleteAllClub {
            deleteAllClub {
                id
            }
        }
    `;

    // Supression de tous les clubs
    request('http://localhost:8080/graphql', mutation)
        .then(response => {
            console.log('Liste des clubs :', response.deleteAllClub);
        })
        .catch(error => {
            console.error('Erreur lors de la récupération des clubs');
        });
};

function delete_one_club(id)
{
    const mutation = gql`
        mutation DeleteOneClubById {
            deleteOneClubById(id: "`+id+`"){
                id
                name
                city
                league
            }
        }
    `;

    // Supression d'un club
    request('http://localhost:8080/graphql', mutation)
        .then(response => {
            console.log('Liste des clubs :', response.deleteOneClubById);
        })
        .catch(error => {
            console.error('Erreur lors de la récupération des clubs');
        });
}

module.exports = {
    delete_all_player,
    delete_one_player,
    delete_all_club,
    delete_one_club
  };