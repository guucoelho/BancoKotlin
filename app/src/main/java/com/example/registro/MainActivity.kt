package com.example.registro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var nome: EditText
    lateinit var cpf: EditText
    lateinit var email: EditText
    lateinit var celular: EditText
    lateinit var masc: RadioButton
    lateinit var fem: RadioButton
    lateinit var bot: Button
    lateinit var bot1: Button
    lateinit var lista: ListView
    lateinit var genero: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nome = findViewById(R.id.nome) as EditText
        cpf = findViewById(R.id.nome) as EditText
        email = findViewById(R.id.nome) as EditText
        celular = findViewById(R.id.nome) as EditText
        masc = findViewById(R.id.masculino) as RadioButton
        fem = findViewById(R.id.feminino) as RadioButton
        bot = findViewById(R.id.botao) as Button
        bot1 = findViewById(R.id.bot1) as Button
        lista = findViewById(R.id.list) as ListView
        genero = findViewById(R.id.radioGroup) as RadioGroup
        var sexo = ""
        if (masc.isChecked) {
            sexo = "Maculino"
        } else (fem.isChecked)
        {
            sexo = "Feminino"
        }

        var users = arrayListOf<Any>()
        var codig = arrayListOf<Any>()


        bot.setOnClickListener {
            var A = Cadastro(
                nome.text.toString(),
                cpf.text.toString(),
                email.text.toString(),
                celular.text.toString(),
                sexo
            )


            val db = DBHelper(this, null)
            try {
                db.addName("sadfasd", "sadfas", "fasfas", "fsadfasdf")
                Toast.makeText(this, A.nome + " adicionado com Sucesso", Toast.LENGTH_LONG).show()
                limpar()
            } catch (e: Exception) {

            }
        }
            bot1.setOnClickListener {
                val db = DBHelper(this, null)

                    val cursor = db.getName()
                    cursor!!.moveToFirst()

                    cursor.getString(0)


                    users = arrayListOf(

                        "Nome:" + cursor.getString(1) + " CPF: " + cursor.getString(2)
                    )
                    codig.add(cursor.getString(0))
                    while (cursor.moveToNext()) {
                        users.add(

                            "Nome:" + cursor.getString(1) + " CPF: " + cursor.getString(2)

                        )
                        codig.add(cursor.getString(2))
                    }
                    var arrayAdapte: ArrayAdapter<*>
                    arrayAdapte = ArrayAdapter(
                        this,
                        android.R.layout.simple_list_item_1, users
                    )
                    lista.adapter = arrayAdapte



            }

            /* val popup = AlertDialog.Builder(this)
        popup.setTitle("Criar Conta")
        popup.setMessage("Conta criada com sucesso\n" + "dados do aluno:\n"+ "Nome:${A.nome}" + "CPF: ${A.cpf}"+ "Email: ${A.email}"+ "Celular: ${A.celular}")
        popup.setPositiveButton("Confirmar", DialogInterface.OnClickListener { dialog, which -> // Mostra uma mensagem de confirmação
            Toast.makeText(this, "Confirmado", Toast.LENGTH_SHORT).show()
        })
        popup.show()
   */


    }
    fun limpar() {
        nome.text.clear()
        cpf.text.clear()
        email.text.clear()
        celular.text.clear()
        genero.clearCheck()
    }
}