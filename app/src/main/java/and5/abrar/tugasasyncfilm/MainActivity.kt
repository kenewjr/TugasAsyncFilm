package and5.abrar.tugasasyncfilm

import and5.abrar.tugasasyncfilm.adapter.AdapterFilm
import and5.abrar.tugasasyncfilm.vm.ViewModelFilm
import android.app.ProgressDialog
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var adapterFilm: AdapterFilm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AsyncFilm().execute()
    }
    inner class AsyncFilm : AsyncTask<Void,Void,Void>(){
        private lateinit var pDialog : ProgressDialog
        override fun doInBackground(vararg p0: Void?): Void? {
            initRecyclerView()
            return null
        }
        override fun onPreExecute() {
            super.onPreExecute()
            pDialog = ProgressDialog(this@MainActivity)
            pDialog.show()
        }
        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            rvFilm.adapter = adapterFilm
            getDataFilm()
            pDialog.dismiss()
        }

    }
    private fun getDataFilm() {
        val viewModel = ViewModelProvider(this).get(ViewModelFilm::class.java)
        viewModel.getLivedatFilm().observe(this, Observer{
            if(it!=null){
                adapterFilm.setDataFilm(it)
                adapterFilm.notifyDataSetChanged()
            }
        })
        viewModel.getApiFilm()
    }
    private fun initRecyclerView() {
        rvFilm.layoutManager = LinearLayoutManager(this)
        adapterFilm = AdapterFilm()
        rvFilm.adapter = adapterFilm
    }
}