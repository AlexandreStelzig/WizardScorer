package alexstelzig.wizardscorer

import alexstelzig.wizardscorer.playerselection.PlayerSelectionViewModel
import alexstelzig.wizardscorer.utils.InjectorUtils
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels

class PlayerSelectionFragment : Fragment() {

    private val viewModel: PlayerSelectionViewModel by viewModels {
        InjectorUtils.providePlayerSelectionViewModelFactory()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_player_selection, container, false)
    }
}
