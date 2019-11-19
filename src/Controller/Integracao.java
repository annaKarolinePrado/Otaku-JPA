package Controller;

import Model.Cartao;
import Model.Categoria;
import Model.Cidade;
import Model.Conta;
import Model.Episodio;
import Model.Filme;
import Model.Plano;
import Model.Produtora;
import Model.Serie;
import Model.Temporada;
import Model.Usuario;
import com.google.gson.Gson;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Integracao {
    public void sendJSON(String urlEnviar,List lista) throws MalformedURLException, IOException{
        URL url = new URL(urlEnviar);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        //
        Gson gson = new Gson();
        Map<String,String> params = new HashMap<>();
        //
        params.put("json", gson.toJson(lista));
        //
        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String, String> param : params.entrySet()) {
            if (postData.length() != 0) {
                postData.append('&');
            }
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }

        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        
        try (DataOutputStream writer = new DataOutputStream(connection.getOutputStream())) {
            writer.write(postDataBytes);
            writer.flush();
            writer.close();            
            InputStream r = connection.getInputStream();
        } finally {
            connection.disconnect();
        } 
    }
    
    public void integrarConta(){
        Gson gson = new Gson();
        Conta[] conta = null;
        try{
            Reader reader = new FileReader("conta.json");
            conta = gson.fromJson(reader, Conta[].class);
        }catch(FileNotFoundException ex){
            System.out.println("ERRO Arquivo:"+ex.getMessage());
        }
        for(Conta c : conta){
            ContaDAO dao =  new ContaDAO();            
            dao.add(c);
        }
     }
    
    public void integrarFilme(){
        Gson gson = new Gson();
        Filme[] filme = null;
        try{
            Reader reader = new FileReader("filme.json");
            filme = gson.fromJson(reader, Filme[].class);
        }catch(FileNotFoundException ex){
            System.out.println("ERRO Arquivo:"+ex.getMessage());
        }
        for(Filme f : filme){
            FilmeDAO daoFilme =  new FilmeDAO();            
            daoFilme.add(f);
        }
     }
    public void integrarCartao(){
        Gson gson = new Gson();
        Cartao[] cartao = null;
        try{
            Reader reader = new FileReader("cartao.json");
            cartao = gson.fromJson(reader, Cartao[].class);
        }catch(FileNotFoundException ex){
            System.out.println("ERRO Arquivo:"+ex.getMessage());
        }
        for(Cartao obj : cartao){
            CartaoDAO objDao =  new CartaoDAO();            
            objDao.add(obj);
        }
     }
    public void integrarCategoria(){
        Gson gson = new Gson();
        Categoria[] categoria = null;
        try{
            Reader reader = new FileReader("categoria.json");
            categoria = gson.fromJson(reader, Categoria[].class);
        }catch(FileNotFoundException ex){
            System.out.println("ERRO Arquivo:"+ex.getMessage());
        }
        for(Categoria obj : categoria){
            CategoriaDAO objDao =  new CategoriaDAO();            
            objDao.add(obj);
        }
     }
     public void integrarCidade(){
        Gson gson = new Gson();
        Cidade[] cidade = null;
        try{
            Reader reader = new FileReader("cidade.json");
            cidade = gson.fromJson(reader, Cidade[].class);
        }catch(FileNotFoundException ex){
            System.out.println("ERRO Arquivo:"+ex.getMessage());
        }
        for(Cidade obj : cidade){
            CidadeDAO objDao =  new CidadeDAO();            
            objDao.add(obj);
        }
     }
     public void integrarEpsodio(){
        Gson gson = new Gson();
        Episodio[] epsodio = null;
        try{
            Reader reader = new FileReader("epsodio.json");
            epsodio = gson.fromJson(reader, Episodio[].class);
        }catch(FileNotFoundException ex){
            System.out.println("ERRO Arquivo:"+ex.getMessage());
        }
        for(Episodio obj : epsodio){
            EpisodioDAO objDao =  new EpisodioDAO();            
            objDao.add(obj);
        }
     }
     public void integrarPlano(){
        Gson gson = new Gson();
        Plano[] plano = null;
        try{
            Reader reader = new FileReader("plano.json");
            plano = gson.fromJson(reader, Plano[].class);
        }catch(FileNotFoundException ex){
            System.out.println("ERRO Arquivo:"+ex.getMessage());
        }
        for(Plano obj : plano){
            PlanoDAO objDao =  new PlanoDAO();            
            objDao.add(obj);
        }
     }
     public void integrarProdutora(){
        Gson gson = new Gson();
        Produtora[] produtora = null;
        try{
            Reader reader = new FileReader("produtora.json");
            produtora = gson.fromJson(reader, Produtora[].class);
        }catch(FileNotFoundException ex){
            System.out.println("ERRO Arquivo:"+ex.getMessage());
        }
        for(Produtora obj : produtora){
            ProdutoraDAO objDao =  new ProdutoraDAO();            
            objDao.add(obj);
        }
     }
     public void integrarSerie(){
        Gson gson = new Gson();
        Serie[] serie = null;
        try{
            Reader reader = new FileReader("serie.json");
            serie = gson.fromJson(reader, Serie[].class);
        }catch(FileNotFoundException ex){
            System.out.println("ERRO Arquivo:"+ex.getMessage());
        }
        for(Serie obj : serie){
            SerieDAO objDao =  new SerieDAO();            
            objDao.add(obj);
        }
     }
      public void integrarTemporada(){
        Gson gson = new Gson();
        Temporada[] temporada = null;
        try{
            Reader reader = new FileReader("serie.json");
            temporada = gson.fromJson(reader, Temporada[].class);
        }catch(FileNotFoundException ex){
            System.out.println("ERRO Arquivo:"+ex.getMessage());
        }
        for(Temporada obj : temporada){
            TemporadaDAO objDao =  new TemporadaDAO();            
            objDao.add(obj);
        }
     }
     public void integrarUsuario(){
        Gson gson = new Gson();
        Usuario[] usuario = null;
        try{
            Reader reader = new FileReader("usuario.json");
            usuario = gson.fromJson(reader, Usuario[].class);
        }catch(FileNotFoundException ex){
            System.out.println("ERRO Arquivo:"+ex.getMessage());
        }
        for(Usuario obj : usuario){
            UsuarioDAO objDao =  new UsuarioDAO();            
            objDao.add(obj);
        }
     }
}
