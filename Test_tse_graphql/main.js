const { get_all_club, get_all_player } = require('./get.js');
const { delete_all_player, delete_one_player, delete_all_club, delete_one_club } = require('./delete.js');
const { post_one_club, post_one_player } = require('./post.js');
const { put_one_club, put_one_player } = require('./put.js');

const waiting_time = 300;

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function demo() {
    console.log('============ Initialisation (DELETE) ============');
    await sleep(waiting_time)
    delete_all_player();
    await sleep(waiting_time)
    delete_all_club();
    await sleep(waiting_time)
    console.log('\n');

    console.log('============ Démo Clubs ============');
    await sleep(waiting_time)
    console.log('\n');

    console.log('Affichage des clubs déjà présents dans la BDD');
    get_all_club();
    await sleep(waiting_time);
    console.log('\n');

    console.log('Ajout de clubs en cours...');
    post_one_club("club-1", "ASSE", "SAINT-ETIENNE", "LIGUE 2");
    await sleep(waiting_time);
    post_one_club("club-2", "OL", "LYON", "LIGUE 1");
    await sleep(waiting_time);
    post_one_club("club-3", "PSG", "PARIS", "LIGUE 1");
    await sleep(waiting_time);
    post_one_club("club-4", "ATLETICO DE MADRID", "MADRID", "LA LIGA");
    await sleep(waiting_time);
    post_one_club("club-5", "AC MILAN", "MILAN", "SERIE A");
    await sleep(waiting_time)
    get_all_club();
    await sleep(waiting_time);
    console.log('\n');

    console.log('Suppression du club AC Milan (club-5)');
    delete_one_club("club-5");
    await sleep(waiting_time);
    console.log('\n');

    console.log('Modification du club l\'OL en l\'OM (club-2)');
    put_one_club("club-2", "OM", "MARSEILLE", "LIGUE 1");
    await sleep(waiting_time);
    get_all_club();
    await sleep(waiting_time);
    console.log('\n');

    console.log('============ Démo Joueurs ============');
    await sleep(waiting_time)
    console.log('\n');

    console.log('Affichage des joueurs déjà présents dans la BDD');
    get_all_player();
    await sleep(waiting_time);
    console.log('\n');

    console.log('Ajout de joueurs en cours...');
    post_one_player("player-1", "Jérémy", "Morel", "Attaquant", "7", "club-1");
    await sleep(waiting_time);
    post_one_player("player-2", "Antoine", "Griezmann", "Attaquant", "7", "club-4");
    await sleep(waiting_time);
    post_one_player("player-3", "Kylian", "Mbappé", "Attaquant", "10", "club-3");
    await sleep(waiting_time);
    get_all_player();
    await sleep(waiting_time);
    console.log('\n');

    console.log('Suppression du joueur Jérémy Morel (player-1)');
    delete_one_player("player-1");
    await sleep(waiting_time);
    console.log('\n');

    console.log('Modification du joueur Kylian Mvappé en Etienne Green');
    put_one_player("player-3", "Etienne", "Green", "Gardien", "42", "club-1");
    await sleep(waiting_time);
    get_all_player();
    await sleep(waiting_time);
    console.log('\n');
}

demo();
