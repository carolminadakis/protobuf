package br.com.zup

import io.grpc.ManagedChannelBuilder

fun main() {

    val channel = ManagedChannelBuilder.forAddress("localhost", 50051)
        .usePlaintext()
        .build()

    val client = FuncionarioServiceGrpc.newBlockingStub(channel)
    val request = FuncionarioRequest.newBuilder()
        .setNome("Ana Carolina")
        .setCpf("123.456.789-10")
        .setIdade(36)
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
   val response = client.cadastrar(request)

    println(response)
}