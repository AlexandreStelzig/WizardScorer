package alexstelzig.wizardscorer.playerselection

import alexstelzig.wizardscorer.R
import alexstelzig.wizardscorer.databinding.FragmentNewGameBinding
import alexstelzig.wizardscorer.utils.InjectorUtils
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController

class NewGameFragment : Fragment() {

    private val viewModel: NewGameViewModel by viewModels {
        InjectorUtils.providePlayerSelectionViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNewGameBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        initNumberOfPlayersButtons(binding)
        initStartButton(binding)

        return binding.root
    }

    private fun initStartButton(binding: FragmentNewGameBinding) {
        binding.startButton.setOnClickListener { v ->
            v.findNavController().navigate(R.id.action_playerSelectionFragment_to_gameFragment)
        }
    }

    private fun initNumberOfPlayersButtons(binding: FragmentNewGameBinding) {
        binding.increaseNumberPlayerButton.setOnClickListener {
            viewModel.incrementNumberOfPlayers()
            binding.scrollView?.post(Runnable { binding.scrollView.fullScroll(View.FOCUS_DOWN) })
        }

        binding.decreaseNumberPlayerButton.setOnClickListener {
            viewModel.decrementNumberOfPlayers()
        }
    }
}
