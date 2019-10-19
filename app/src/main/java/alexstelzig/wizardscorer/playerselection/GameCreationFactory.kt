package alexstelzig.wizardscorer.playerselection

import alexstelzig.wizardscorer.data.game.Game
import alexstelzig.wizardscorer.data.player.Player
import alexstelzig.wizardscorer.data.playerround.PlayerRound
import alexstelzig.wizardscorer.data.round.Round

// todo change to Worker
object GameCreationFactory {

    private const val NUMBER_OF_CARDS = 60

    fun createGame(playerNames: List<String>, firstDealerIndex: Int, completion: ((Game) -> Unit)) {
        val players = createPlayers(playerNames)
        val rounds = createRounds(players)
        completion(
            Game(
                players = players as ArrayList<Player>,
                rounds = rounds as ArrayList<Round>,
                firstDealer = players[firstDealerIndex]
            )
        )

    }

    private fun createPlayers(playerNames: List<String>): List<Player> {
        val playerList: MutableList<Player> = mutableListOf()
        playerNames.forEach { playerName ->
            playerList.add(Player(playerName))
        }
        return playerList
    }

    private fun createRounds(players: List<Player>): List<Round> {
        val numberOfRounds = NUMBER_OF_CARDS / players.size
        val rounds: MutableList<Round> = mutableListOf()

        for (roundIndex in 0 until numberOfRounds) {
            rounds.add(Round(createPlayerRound(players)))
        }
        return rounds
    }

    private fun createPlayerRound(players: List<Player>): List<PlayerRound> {
        val playerRounds: MutableList<PlayerRound> = mutableListOf()

        players.forEach { player ->
            playerRounds.add(PlayerRound(player))
        }
        return playerRounds
    }
}