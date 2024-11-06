package br.com.etecia.nutriapp.API;

public class Api {
    private static final String ROOT_URL = "http://10.67.96.223/apinutriplus/v1/Api.php?apicall=";

    public static final String URL_CREATE_PRODUTOS = ROOT_URL + "createProdutos";
    public static final String URL_READ_PRODUTOS = ROOT_URL + "getProdutos";
    public static final String URL_UPDATE_PRODUTOS = ROOT_URL + "updateProdutos";
    public static final String URL_DELETE_PRODUTOS = ROOT_URL + "deleteProdutos";
}
