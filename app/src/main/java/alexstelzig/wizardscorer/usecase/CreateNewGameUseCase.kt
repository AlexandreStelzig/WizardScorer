package alexstelzig.wizardscorer.usecase

import alexstelzig.wizardscorer.data.game.Game
import alexstelzig.wizardscorer.data.game.GameRepository
import alexstelzig.wizardscorer.data.player.Player
import alexstelzig.wizardscorer.data.player.PlayerRepository
import alexstelzig.wizardscorer.data.playerround.PlayerRound
import alexstelzig.wizardscorer.data.playerround.PlayerRoundRepository
import alexstelzig.wizardscorer.data.round.Round
import alexstelzig.wizardscorer.data.round.RoundRepository

private const val NUMBER_OF_CARDS = 60

class CreateNewGameUseCase(
    private val gameRepository: GameRepository,
    private val playerRepository: PlayerRepository,
    private val roundRepository: RoundRepository,
    private val playerRoundRepository: PlayerRoundRepository
) {

    suspend fun perform(playerNames: List<String>, firstDealerIndex: Int) {
        val numberOfRounds = NUMBER_OF_CARDS / playerNames.size

        val gameId = createGame(gameRepository)
        val playerIds = createPlayers(playerNames, gameId, playerRepository)
        val roundIds = createRounds(numberOfRounds, gameId, roundRepository)
        createPlayerRounds(roundIds, playerIds, playerRoundRepository)
    }

    private suspend fun createPlayerRounds(
        roundIds: List<Long>,
        playerIds: List<Long>,
        playerRoundRepository: PlayerRoundRepository
    ) {
        val playerRounds = mutableListOf<PlayerRound>()
        roundIds.forEach { roundId ->
            playerIds.forEach { playerId ->
                playerRounds.add(PlayerRound(playerId, roundId))
            }
        }
        playerRoundRepository.insertAllPlayerRounds(playerRounds)
    }

    private suspend fun createRounds(
        numberOfRounds: Int,
        gameId: Long,
        roundRepository: RoundRepository
    ): List<Long> {
        val rounds = mutableListOf<Round>()
        for (index in 0 until numberOfRounds) {
            rounds.add(Round(gameId, index))
        }
        return roundRepository.insertAllRounds(rounds)
    }

    private suspend fun createPlayers(
        playerNames: List<String>,
        gameId: Long,
        playerRepository: PlayerRepository
    ): List<Long> {
        val players = mutableListOf<Player>()
        playerNames.forEach { playerName ->
            players.add(Player(playerName, gameId))
        }
        return playerRepository.insertAllPlayers(players)
    }

    private suspend fun createGame(gameRepository: GameRepository): Long {
        val game = Game()
        val gameId = gameRepository.insertGame(game)
        return gameId
    }
}