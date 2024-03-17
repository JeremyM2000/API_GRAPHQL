const { gql, request } = require('graphql-request')

function post_one_club(id, name, city, league)
{
    
    const mutation = gql`
        mutation PostOneClub {
            postOneClub(id:"`+id+`", name: "`+name+`", city:"`+city+`", league:"`+league+`") {
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
        //     console.log('Liste des clubs :', response.postOneClub);
        // })
        // .catch(error => {
        //     console.error('Erreur lors de la récupération des clubs');
        // });
};

function post_one_player(id, firstName, lastName, position, number, clubId)
{
    
    const mutation = gql`
        mutation postOnePlayer {
            postOnePlayer(id: "`+id+`", firstName: "`+firstName+`", lastName: "`+lastName+`", position: "`+position+`", number: `+number+`, clubId: "`+clubId+`") {
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
    post_one_club,
    post_one_player
  };