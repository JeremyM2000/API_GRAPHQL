const { gql, request } = require('graphql-request')

function put_one_club(id, name, city, league)
{
    
    const mutation = gql`
        mutation PutOneClub {
            putOneClub(id:"`+id+`", name: "`+name+`", city:"`+city+`", league:"`+league+`") {
                id
                name
                city
                league
            }
        }
    `;

    // Envoie d'un club
    request('http://localhost:8080/graphql', mutation);
        // .then(response => {
        //     console.log('Liste des clubs :', response.putOneClub);
        // })
        // .catch(error => {
        //     console.error('Erreur lors de la récupération des clubs');
        // });
};

function put_one_player(id, firstName, lastName, position, number, clubId)
{
    
    const mutation = gql`
        mutation putOnePlayer {
            putOnePlayer(id: "`+id+`", firstName: "`+firstName+`", lastName: "`+lastName+`", position: "`+position+`", number: `+number+`, clubId: "`+clubId+`") {
                id
                firstName
                lastName
            }
        }
    `;

    // Envoie d'un club
    request('http://localhost:8080/graphql', mutation);
        // .then(response => {
        //     console.log('Liste des clubs :', response.postOneClub);
        // })
        // .catch(error => {
        //     console.error('Erreur lors de la récupération des clubs');
        // });
};

module.exports = {
    put_one_club,
    put_one_player
  };