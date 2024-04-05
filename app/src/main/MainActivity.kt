import android.app.Application
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import java.lang.reflect.Modifier
import java.nio.file.WatchEvent.Modifier

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent{
            App()
        }
    }
}

class MyApp: Application(){
    //custom props go here
//    object ProtoSerializer: Serializer<MyProto>{
//        override val defaultValue: MyProto = MyProto.getDefaultInstance()
//        override suspend fun readFrom
//    }
}

class CustomViewModel(): ViewModel() {
    companion object Factory {
        val Factory = viewModelFactory {
            initializer {
                val app = (this[APPLICATION_KEY] as MyApp)
                CustomViewModel()
            }
        }
    }
}

@Composable
fun App() {
    val nav = rememberNavController()
    Lab4Part1Theme{
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        )
    }
    NavHost(navController = nav, startDestination = "/"){
        //define routes here funny man
    }
}