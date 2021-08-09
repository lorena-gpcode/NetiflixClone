package com.lorena.netiflixclone

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.lorena.netiflixclone.databinding.ActivityFormLoginBinding

class FormLogin : AppCompatActivity() {

    private lateinit var bindig: ActivityFormLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(bindig.root)

        supportActionBar!!.hide()
        VerificarUsuarioLogado()

        // ação o link excreva-se agora
        bindig.txtTelaCadastro.setOnClickListener {
            val intent = Intent(this, FormCadastro::class.java)
            startActivity(intent)
        }

        // ação para o botão entrar
        bindig.btEntrar.setOnClickListener {
            //Toast.makeText(this, "Teste", Toast.LENGTH_SHORT).show()
            val email = bindig.editEmail.text.toString()
            val senha = bindig.editSenha.text.toString()
            val mensagem_erro = bindig.messageErro

            if (email.isEmpty() || senha.isEmpty()) {
                mensagem_erro.setText("Preencha todos os campos")
            } else {
                AutenticarUsuario()
            }

        }
    }
    private fun AutenticarUsuario() {
        val email = bindig.editEmail.text.toString()
        val senha = bindig.editSenha.text.toString()
        val mensagem_erro = bindig.messageErro

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener {

                if (it.isSuccessful) {
                    Toast.makeText(this, "login feito com sucesso!", Toast.LENGTH_SHORT).show()
                    IrParaTelaDeFilmes()
                }
            }.addOnFailureListener {

                var erro = it

                when{

                    erro is FirebaseAuthInvalidCredentialsException -> mensagem_erro.setText("Email  ou senha estão incorretos")
                    erro is FirebaseNetworkException-> mensagem_erro.setText("Sem conexão com a internet!")
                    else ->  mensagem_erro.setText("Erro ao logar usuário")

                }

            }
    }

    private fun VerificarUsuarioLogado(){

        val usuarioLogado = FirebaseAuth.getInstance().currentUser
        if (usuarioLogado != null){
            IrParaTelaDeFilmes()
        }
    }

    private fun IrParaTelaDeFilmes() {
        val intent = Intent(this, ListaFilmes::class.java)
        startActivity(intent)
        finish()
    }
}




