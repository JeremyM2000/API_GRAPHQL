const { request } = require('graphql-request')


function get_all_club()
{
    const query = `
    {
        allClub{
            id
            name
            city
            league
        }
    }`;

    request('http://localhost:8080/graphql', query)
        .then(response => {
            console.log('Liste des clubs :', response.allClub);
        })
        .catch(error => {
            console.error('Erreur lors de la récupération des équipes');
        });
}

function get_all_player()
{
    const query = `
    {
        getAllPlayer{
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
    }`;

    request('http://localhost:8080/graphql', query)
        .then(response => {
            console.log('Liste des joueurs :', response.getAllPlayer);
        })
        .catch(error => {
            console.error('Erreur lors de la récupération des joueurs');
        });
}

module.exports = {
    get_all_club,
    get_all_player
  };