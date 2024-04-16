package surf.project.surftask02

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import surf.project.surftask02.databinding.ActivityMainBinding
import surf.project.surftask02.databinding.FragmentLaunchesBinding

class FragmentLaunches : Fragment() {
    private lateinit var binding: FragmentLaunchesBinding
    lateinit var adapter: LaunchAdapter
    val launchList = listOf(
        Launch(R.drawable.img_1, "Starlink 2", "CCAES SLC 40", "16-12-2014"),
        Launch(R.drawable.img_2, "DemoSat", "AAAES SLC 40", "06-07-2018"),
        Launch(R.drawable.img_3, "Falcon 9 Test", "CCAES SEC 40", "18-03-2019"),
        Launch(R.drawable.img, "CRS - 2", "CAAES SLC 40", "18-12-2019"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLaunchesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initLaunchView()
    }

    private fun initLaunchView() = with(binding) {
        adapter = LaunchAdapter()
        launchRV.adapter = adapter
        launchRV.layoutManager = LinearLayoutManager(launchRV.context)
        adapter.submitList(launchList)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentLaunches()
    }
}