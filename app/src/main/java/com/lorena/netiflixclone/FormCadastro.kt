package com.lorena.netiflixclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.lorena.netiflixclone.databinding.ActivityFormCadastroBinding

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        Toolbar()

        binding.btcadastrar.setOnClickListener{

            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()
            val mensagem_erro = binding.messageErro

            if (email.isEmpty() || senha.isEmpty()) {

                mensagem_erro.setText("Preencha todos os campos")

            }else {

                cadastrarUsuario()
            }
        }

    }

    private fun cadastrarUsuario(){

        val email = binding.editEmail.text.toString()
        val senha = binding.editSenha.text.toString()
        val mensagem_erro = binding.messageErro

       FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha).addOnCompleteListener {

           if (it.isSuccessful) {
               // mensagem_erro.setText("Usuário cadastrado com sucesso")

               Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
               binding.editEmail.setText("")
               binding.editSenha.setText("")
               mensagem_erro.setText("")
           }

           }.addOnFailureListener {
              // criar uma variavel erro para o tratamendo
              var erro = it

            // quando erro for ...
              when {
                  // erro de senha  imprima essa mensagem
                  erro is FirebaseAuthWeakPasswordException-> mensagem_erro.setText("Digite uma senha com no minimo 6 caracteres")
                 // erro de cadastro, quando a conta já esta cadastrada imprima, essa mensagem
                  erro is FirebaseAuthUserCollisionException-> mensagem_erro.setText("Esta conta ja foi cadastrada")
                  // erro na conexão da internet o aplicativo não esta conectado, imprima essa mensagem
                  erro is FirebaseNetworkException-> mensagem_erro.setText("Sem conexão com a internet")
                  // Senão imprima erro de cadastro de usuário
                  else -> mensagem_erro.setText("Erro ao cadastrar usuário")

              }

       }


       }





    


    private fun Toolbar(){
        val toolbar = binding.toolbarCadastro
        toolbar.setBackgroundColor(getColor(R.color.white))
        toolbar.setNavigationIcon(getDrawable(R.drawable.ic_netflix_official_logo))

    }
}