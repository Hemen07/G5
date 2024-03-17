package com.example.g5

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.g5.databinding.ActivityMainBinding
import com.example.g5.domain.common.ClientApiResult
import com.example.g5.domain.entities.responses.ClientGithub
import com.example.g5.ui.base.BaseActivity
import com.example.g5.ui.features.two.G1Adapter
import com.example.g5.ui.features.two.MyCustomDialog
import com.example.g5.ui.features.two.VM
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

private const val TAG = "G5-MainActivity : "

/**
 * G5
 */
@AndroidEntryPoint
class MainActivity : BaseActivity() {

    //new way
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private lateinit var g1Adapter: G1Adapter

    @Inject
    lateinit var myCustomDialog: MyCustomDialog

    private val vM: VM by viewModels()

    override fun getToolbarTitle(): String {
        return getString(R.string.app_name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
        setContentView(binding.root)
        //
        initView()
        initRecyclerView()
        //
        vmGenericObserver()
        vM.fetchGitTrendingRepoList()
    }


    private fun initView() {
        //
        binding.apply {
            btnTwo.text = "Loading .........."
            btnOne.setOnClickListener {
                Log.w(TAG, "initView: btnOne")
                myCustomDialog.showDialog()
            }
        }
    }

    private fun initRecyclerView() {
        g1Adapter = G1Adapter(onClickPosition = { pos: Int ->
            Log.w(TAG, "||||||  onClick $pos ")
        })
        //
        binding.rv.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
            adapter = g1Adapter
        }
        g1Adapter.loadEmptyData()
    }


    /**
     * Generic observer
     * Uses [ClientApiResult]
     */
    private fun vmGenericObserver() {
        Log.d(TAG, "vmGenericObserver: ")
        vM.uiState().observe(this@MainActivity) { state ->
            binding.btnTwo.text = "TWO"
            when (state) {
                is ClientApiResult.Loading -> {
                    Log.i(TAG, "vmGenericObserver:  observe -> LOADING")
                }

                is ClientApiResult.Success -> {
                    Log.i(TAG, "vmGenericObserver:  observe -> SUCCESS = ${state.data}")
                    if (state.data is List<*>) {
                        val list = state.data.filterIsInstance<ClientGithub>()
                        g1Adapter.setNewData(list.ifEmpty { emptyList() })
                    }
                }

                is ClientApiResult.Error -> {
                    Log.e(TAG, "vmGenericObserver:  observe -> ERROR = ${state.errorMessage}")
                }

                is ClientApiResult.Exception -> {
                    Log.e(TAG, "vmGenericObserver:  observe -> Exception = ${state.throwable}")
                }
            }
        }
    }
}
