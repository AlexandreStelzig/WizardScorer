package alexstelzig.wizardscorer.playerselection

import alexstelzig.wizardscorer.databinding.FragmentNewGameBinding
import alexstelzig.wizardscorer.utils.InjectorUtils
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe

class NewGameFragment : Fragment() {

    private val viewModel: NewGameViewModel by viewModels {
        InjectorUtils.providePlayerSelectionViewModelFactory(requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentNewGameBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.viewModel = viewModel

        binding.increaseNumberPlayerButton.setOnClickListener {
            viewModel.incrementNumberOfPlayers()
            binding?.invalidateAll()
            binding?.scrollView?.post(Runnable { binding.scrollView?.fullScroll(View.FOCUS_DOWN) })
        }
        binding.decreaseNumberPlayerButton.setOnClickListener {
            viewModel.decrementNumberOfPlayers()
            binding?.invalidateAll()
        }

        viewModel.firstDealer.observe(viewLifecycleOwner) {
            binding?.invalidateAll()
        }

        setHasOptionsMenu(true)
        return binding.root
    }
}
