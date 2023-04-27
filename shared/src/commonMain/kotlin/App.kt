import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)

@Composable
fun App() {
    val itemscount = remember {  (0..15).toList()}
//    Scaffold(content = {
//        LazyColumn{
//            items(itemscount.size, key = {itemscount[it]}){
//                ArtistCard()
//            }
//        }
//    })

    Scaffold {

        Column (modifier = Modifier.verticalScroll(rememberScrollState())){
            itemscount.forEach {
                ArtistCard()
            }
        }
    }

}

@Composable
fun space10Dp() {
    Spacer(modifier = Modifier.size(10.dp))
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ArtistCard(names: List<String>? = null) {


    Column(modifier = Modifier.padding(10.dp).clickable { }) {
        Row {
            Image(
                modifier = Modifier.size(75.dp).clip(CircleShape)
                    .border(width = 2.dp, color = Color.Black, shape = CircleShape),
                painter = painterResource("compose-multiplatform.xml"),
                contentDescription = null
            )
            space10Dp()
            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text("Alfred Sisley")
                Text("3 minutes ago")
            }
        }
        space10Dp()
        Image(
            painter = painterResource("img.png"), contentDescription = "",
            modifier = Modifier.clip(shape = RoundedCornerShape(percent = 10)).fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
    }

}

expect fun getPlatformName(): String


//var greetingText by remember { mutableStateOf("Hello, World!") }
//var showImage by remember { mutableStateOf(false) }
//var counter : Int by remember { mutableStateOf(0) }
//Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//    Button(onClick = {
//        greetingText = "Hello, ${getPlatformName()}"
//        showImage = !showImage
//    }) {
//        Text(greetingText)
//    }
//    Text("This is the shared Component")
//    Button(onClick = {
//        counter++
//    }, modifier = Modifier.fillMaxWidth()){
//        Text("count value $counter")
//    }
//    AnimatedVisibility(showImage) {
//        Image(
//            painterResource("compose-multiplatform.xml"),
//            null
//        )
//    }
//}