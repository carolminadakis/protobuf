package br.com.zup

import java.io.FileInputStream
import java.io.FileOutputStream


fun main() {
    val request = FuncionarioRequest.newBuilder()
        .setNome("Ana Carolina")
        .setCpf("123.456.789-10")
        .setSalario(2000.00)
        .setAtivo(true)
        .setCargo(Cargo.QA)
        .addEnderece(
            FuncionarioRequest.Endereco.newBuilder()
                .setLogradouro("Rua Abrão")
                .setCep("12345-678")
                .setComplemento("casa 1")
                .build()
        )
        .build()

    //escrevemos o objeto
    println(request)
    request.writeTo(FileOutputStream("funcionario-request.bin"))

    val request2 = FuncionarioRequest.newBuilder()
        .mergeFrom(FileInputStream("funcionario-request.bin"))

    request2.setCargo(Cargo.GERENTE).build()
    println(request2)

}
