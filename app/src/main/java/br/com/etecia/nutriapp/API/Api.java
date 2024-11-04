package br.com.etecia.nutriapp.API;

public class Api {
    private static final String ROOT_URL = "http://192.168.0.105./apinutriplus/v1/Api.php?apicall=";

    public static final String URL_CREATE_PRODUTOS = ROOT_URL + "createprodutos";
    public static final String URL_READ_PRODUTOS = ROOT_URL + "getprodutos";
    public static final String URL_UPDATE_PRODUTOS = ROOT_URL + "updateprodutos";
    public static final String URL_DELETE_PRODUTOS = ROOT_URL + "deleteprodutos";
}
