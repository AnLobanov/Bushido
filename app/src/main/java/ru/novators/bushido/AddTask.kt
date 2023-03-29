package ru.novators.bushido

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.novators.bushido.ui.theme.BushidoTheme
import ru.novators.bushido.backbutton.Backbutton
import ru.novators.bushido.maintitle.Maintitle
import ru.novators.bushido.titlesub.Titlesub

class AddTask : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val message = remember{mutableStateOf("")}
            BushidoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState())
                            .padding(start = 16.dp, top = 15.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Backbutton(buttontitle = "Назад", backtaped = { intent = Intent(this@AddTask, MainActivity::class.java)
                            intent.putExtra("EXTRA_TARGET_NAME", message.value)
                            startActivity(intent)
                        })
                        Maintitle(title = "Создать новую цель", subbutton = "",
                            modifier = Modifier.padding(bottom = 15.dp))
                        Titlesub(titletxt = "Название", modifier = Modifier.padding(bottom = 15.dp))
                        TextField(value = message.value, onValueChange = {newText -> message.value = newText})
                    }
                }
            }
        }
    }
}