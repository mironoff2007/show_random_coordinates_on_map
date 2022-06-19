package ru.mironov.showrandomcoordinatesonmap.presentation

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.mironov.showrandomcoordinatesonmap.databinding.MainFragmentBinding
import ru.mironov.showrandomcoordinatesonmap.services.GenService


class MainFragment : Fragment() {

    companion object {
        private const val TRACKING_CHANNEL = "tracking_channel"
        private const val TRACKING_NOTIFICATION_ID = 1
    }

    private val genService = GenService()
    private val mainActivity = MainActivity()

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

//    companion object {
//        fun newInstance() = MainFragment()
//    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            startStopService()
        }
    }

    private fun startStopService() {
        if (isMyServiceRunning(GenService::class.java)) {

            Toast.makeText(context,
                "Service Stopped",
                Toast.LENGTH_SHORT).show()

            requireActivity().stopService(Intent(context,
                GenService::class.java))

        } else {

            Toast.makeText(context,
                "Service Started",
                Toast.LENGTH_SHORT).show()

            requireActivity().startService(Intent(context,
                GenService::class.java))
        }
    }


    private fun isMyServiceRunning(mClass: Class<GenService>): Boolean {

        val manager: ActivityManager = activity?.getSystemService(
            Context.ACTIVITY_SERVICE
        ) as ActivityManager

        for (service: ActivityManager.RunningServiceInfo in
        manager.getRunningServices(Integer.MAX_VALUE)) {

            if (mClass.name.equals(service.service.className)) {
                return true
            }
        }
        return false
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}