package ru.novators.bushido

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import ru.novators.bushido.ui.theme.BushidoTheme
import ru.novators.bushido.greeting.Greeting
import ru.novators.bushido.maintitle.Maintitle
import ru.novators.bushido.taskcard.TaskCard


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val sessionId = getIntent().getStringExtra("EXTRA_TARGET_NAME");
            BushidoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .verticalScroll(rememberScrollState()).padding(start = 16.dp, top=15.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Greeting(greetUser = "Здравствуйте, Василий", modifier = Modifier.padding(bottom = 15.dp))
                        Maintitle(title = "Ближайшие задачи", subbutton = "Все цели", subbuttontaped = {
                            startActivity(Intent(this@MainActivity,AddTask::class.java))
                            finishActivity(1)
                        },
                            modifier = Modifier.padding(bottom = 15.dp))
                        for (i in 0..20) {
                            TaskCard(targetname = "Физика",
                                taskname = "Выучить билеты",
                                datetask = "30.02.2022",
                                tasktapped = {
                                    Toast.makeText(
                                        this@MainActivity,
                                        "TAPPED #${i}",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                                modifier = Modifier.padding(bottom = 15.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}