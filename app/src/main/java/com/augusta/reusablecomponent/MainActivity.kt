package com.augusta.reusablecomponent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.IntOffset
import com.augusta.reaction_popup.ReactionOption
import com.augusta.reusablecomponent.screen.MainContract
import com.augusta.reusablecomponent.screen.MainScreen
import com.augusta.reusablecomponent.screen.MainViewModel
import com.augusta.reusablecomponent.ui.theme.MainAppTheme
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainContract.ViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val activity = LocalContext.current as AppCompatActivity
            MainAppTheme {
                Surface(
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                    val state: MainContract.State by viewModel.collectAsState()
                    MainScreen(
                        state = state,
                        dispatch = viewModel::dispatch,
                        activity = activity
                    )
                    state.reaction?.let { reaction ->
                        ReactionOption(
                            offset = IntOffset(reaction.x - 12, reaction.y - 88),
                            onDismissRequest = {
                                viewModel.dismiss()
                            },
                            onReactionPressed = { emoji ->
                                emoji.emoji
                                viewModel.dismiss()
                            },
                        )
                    }
//                    state.isDialog.let {
//                        if (it) {
//                            NoInternetScreen(
//                                isDialog = state.isDialog,
//                                onClick = {
//                                    viewModel.dismiss(it)
//                                },
//                            )
////                            InfoDialog(isDialog= state.isDialog,
////                                onClick = {
////                                    viewModel.dismiss(it)
////                                },)
////                            BottomInfoDialog(isDialog= state.isDialog,
////                                onClick = {
////                                    viewModel.dismiss(it)
////                                },)
////                            DialogInfo(isDialog= state.isDialog,
////                            onClick = {
////                                viewModel.dismiss(it)
////                            })
//                        }
//                    }
//                    state.isDatePicker.let {
//                        if (it) {
////                            MyContent(onValueChange = {}) { s: String, isDialog: Boolean ->
////                                viewModel.dismiss(isDialog = isDialog)
////                            }
//                            DatePicker(onClick = {s: String, isDialog: Boolean->
//                                if(s.isNotEmpty()){
//                                    Toast.makeText(this, s, Toast.LENGTH_LONG).show()
//                                }
//                                viewModel.dismiss(isDialog = isDialog)
//                            })
////                            SpinnerDatePickerDialog(label = "Date Picker", state.isDatePicker,
////                                onClick = { s: String, isDialog: Boolean ->
////                                    viewModel.dismiss(isDialog = isDialog)
////                                }
////                            )
//                        }
//                    }
//                    state.isTimePicker.let {
//                        if (it) {
////
//                            ImagePicker(
//                                onPicked = {
//                                    viewModel.dismiss(isDialog = false)
//                                },
//                                onClose = {
//                                    viewModel.dismiss(isDialog = false)
//                                }
//
//                            )
//
//
//                        }
//                    }
//
//                    state.isBottomSheet.let {
//                        if (it) {
//                            BottomSheetDialog(
//                                onDismissRequest = {
//                                    Log.d("[BottomSheetDialog]", "onDismissRequest")
//                                    viewModel.dismiss(isDialog = false)
//                                },
//                                properties = BottomSheetDialogProperties()
//                            ) {
//                                Surface(
//                                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
//                                ) {
//                                    Column(
//                                        modifier = Modifier
//                                            .verticalScroll(rememberScrollState())
//                                            .navigationBarsPadding() // for enableEdgeToEdge = true
//                                            .fillMaxWidth()
//                                            .padding(16.dp),
//                                        verticalArrangement = Arrangement.spacedBy(16.dp)
//                                    ) {
//                                        Text(text = "Title", style = MaterialTheme.typography.h5)
//                                        repeat(30) { index ->
//                                            Text(
//                                                modifier = Modifier.clickable { viewModel.dismiss(isDialog = false) },
//                                                text = "Item $index",
//                                                style = MaterialTheme.typography.body1
//                                            )
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }


                }
                viewModel.collectSideEffect { effect ->
                    when (effect) {
                        is MainContract.SideEffect.ReactionPopUp -> {

                        }
                        is MainContract.SideEffect.DialogInfo -> {

                        }
                    }
                }
            }
        }

    }
    private fun goToAppSettings() {
        Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:$packageName")).apply {
            addCategory(Intent.CATEGORY_DEFAULT)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this)
        }
    }
}

//@Composable
//private fun ImagePicker(
//    onPicked: (List<AssetInfo>) -> Unit,
//    onClose: (List<AssetInfo>) -> Unit,
//) {
//    PickerPermissions(permissions = listOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA)) {
//        AssetPicker(
//            assetPickerConfig = AssetPickerConfig(gridCount = 3),
//            onPicked = onPicked,
//            onClose = onClose
//        )
//    }
//}


//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MyApplicationTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Greeting("Android")
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MyApplicationTheme {
//        Greeting("Android")
//    }
//}