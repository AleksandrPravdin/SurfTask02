package surf.project.surftask02

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import surf.project.surftask02.databinding.FragmentLaunchesBinding
import surf.project.surftask02.databinding.FragmentRocketsBinding

class FragmentRockets : Fragment() {
    private lateinit var binding: FragmentRocketsBinding
    lateinit var adapter: RocketAdapter
    val launchList = listOf(
        Rocket(R.drawable.img_1,"Falcon 1","INACTIVE"),
        Rocket(R.drawable.img_4,"Falcon 9","ACTIVE"),
        Rocket(R.drawable.img_3,"Big Falcon Rocket","INACTIVE"),
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRocketsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initRocketView()
    }
    private fun initRocketView() = with(binding) {
        adapter = RocketAdapter()
        rocketsRV.adapter=adapter
        rocketsRV.layoutManager = LinearLayoutManager(rocketsRV.context)
        adapter.submitList(launchList)
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentRockets()
    }
}