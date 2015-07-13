package br.com.gdgtresrios.centrosulnegocios.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.gdgtresrios.centrosulnegocios.model.CategoriaColaborador;
import br.com.gdgtresrios.centrosulnegocios.model.CategoriaEvento;

public class DatabaseConnection extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "centrosulnegocios";
    private static final Integer DATABASE_VERSION = 1;
    private DateFormat mFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private final List<String> createTableList = new ArrayList<>();

    private final List<String> dropTables = new ArrayList<>();

    private String sdateEventoGuto = "15/07/2015 20:00";
    private Date dateEventoGuto;
    private String sdateEventoRodrigo  = "16/07/2015 20:00";
    private Date dateEventoRodrigo;
    private String sdateEventoBel  = "17/07/2015 20:00";
    private Date dateEventoBel;
    private String sdateEventoRey  = "18/07/2015 20:00";
    private Date dateEventoRey;
    private String sdateEventoMisturaFina  = "15/07/2015 21:30";
    private Date dateEventoMisturaFina;
    private String sdateEventoThiagoPierre  = "16/07/2015 21:30";
    private Date dateEventoThiagoPierre;
    private String sdateEventoLeonardoFabiano  = "16/07/2015 22:30";
    private Date dateEventoLeonardoFabiano;
    private String sdateEventoLarissaJulien  = "17/07/2015 21:30";
    private Date dateEventoLarissaJulien;
    private String sdateEventoRafaelSantos  = "17/07/2015 23:30";
    private Date dateEventoRafaelSantos;
    private String sdateEventoAcustico  = "18/07/2015 21:30";
    private Date dateEventoAcustico;
    private String sdateEventoReplay  = "18/07/2015 23:30";
    private Date dateEventoReplay;
    private String sdateEventoSebraeRodadaCredito  = "16/07/2015 14:00";
    private Date dateEventoSebraeRodadaCredito;
    private String sdateEventoSebraeMei  = "16/07/2015 18:00";
    private Date dateEventoSebraeMei;
    private String sdateEventoSebraeDinheiroInovacao  = "16/07/2015 19:00";
    private Date dateEventoSebraeDinheiroInovacao;
    private String sdateEventoSebraeEmpreendedorismo  = "17/07/2015 18:00";
    private Date dateEventoSebraeEmpreendedorismo;
    private String sdateEventoSebraeNegociacaoEmpresarial  = "17/07/2015 18:00";
    private Date dateEventoSebraeNegociacaoEmpresarial;
    private String sdateEventoSebraeConstruindoIdentidade  = "17/07/2015 19:00";
    private Date dateEventoSebraeConstruindoIdentidade;
    private String sdateEventoSebraeRedesSociais  = "18/07/2015 19:00";
    private Date dateEventoSebraeRedesSociais;
    private String sdateEventoSebraeStarupRJ  = "18/07/2015 14:40";
    private Date dateEventoSebraeStarupRJ;
    private String sdateEventoMostraProjetosTecnologicos  = "18/07/2015 15:30";
    private Date dateEventoMostraProjetosTecnologicos;
    private String sdateEventoEngenheiroComputacao  = "18/07/2015 16:00";
    private Date dateEventoEngenheiroComputacao;
    private String sdateEventoMostraJogos  = "18/07/2015 16:40";
    private Date dateEventoMostraJogos;
    private String sdateEvento50dicas  = "18/07/2015 17:30";
    private Date dateEvento50dicas;



    public DatabaseConnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CategoriaEventoDao.CREATE_TABLE);
        db.execSQL(CategoriaColaboradorDao.CREATE_TABLE);
        db.execSQL(ColaboradorDao.CREATE_TABLE);
        db.execSQL(EventoDao.CREATE_TABLE);
        db.execSQL(ConfiguracaoDao.CREATE_TABLE);

        db.execSQL("INSERT INTO " + CategoriaEventoDao.TABLE_NAME + "(" + CategoriaEventoDao.COLUMN_NOME + ") VALUES('Palestras')");  //1
        db.execSQL("INSERT INTO " + CategoriaEventoDao.TABLE_NAME + "(" + CategoriaEventoDao.COLUMN_NOME + ") VALUES('Shows')");      //2
        db.execSQL("INSERT INTO " + CategoriaEventoDao.TABLE_NAME + "(" + CategoriaEventoDao.COLUMN_NOME + ") VALUES('Workshops')");  //3
        db.execSQL("INSERT INTO " + CategoriaEventoDao.TABLE_NAME + "(" + CategoriaEventoDao.COLUMN_NOME + ") VALUES('Estandes')");   //4

        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Informática')");  //1
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Bandas')");       //2
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Comércio')");     //3
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Turismo')");      //4
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Palestrante')");  //5
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Empreendedorismo')");  //6

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Guto Abranches'," +
                "'Âncora do programa Conta Corrente 2ª edição, apresentado pela GloboNews...', " +
                "'Âncora do programa Conta Corrente 2ª edição, apresentado pela GloboNews, passou pelas emissoras CNT e Cultura, além do jornal Folha de São Paulo e a revista Veja.'," +
                " 1, 0, 0, 5)"); // 1

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Rodrigo Pimentel'," +
                "'Ex-Capitão do BOPE que serviu de inspiração para o Capitão Nascimento...', " +
                "'Ex-Capitão do BOPE, Rodrigo Pimentel, é um dos oficiais que serviu de inspiração para o Capitão Nascimento, interpretado pelo ator Wagner Moura.'," +
                " 1, 0, 0, 5)"); //2

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Bel Pesce'," +
                "'Empreendedora, fundadora da FazINOVA  e autora de três livros...', " +
                "'Empreendedora, fundadora da FazINOVA  e autora de três livros: A Menina do Vale, Procuram-se Super Herois e A Menina do Vale 2. Foi considerada uma das “100 pessoas mais influentes do Brasil”, pela Revista Época.'," +
                " 1, 0, 0, 5)"); // 3

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Dr. Robert Rey'," +
                "'Conhecido como Dr. Rey é um cirurgião plástico e apresentador brasileiro...', " +
                "'Conhecido como Dr. Rey é um cirurgião plástico e apresentador brasileiro e um dos protagonistas do Dr. 90210 (um reality show exibido nos Estados Unidos pelos canais E! Entertainment e People and Arts.'," +
                " 1, 0, 0, 5)"); // 4

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Mistura Fina'," +
                "'MPB...', " +
                "'A história da banda começa com os integrantes se conhecendo na banda Primeiro de Maio e decidindo formar um trio para tocar músicas de cantores famosos que não são executadas há muito tempo. A banda, mais tarde nomeada de Mistura Fina, é composta por Alex Souza (voz e cajón), Pablo Martins (violão e voz) e Wander Leal (Sopros) e tem tocado músicas que geralmente não são ouvidas com frequência, com novos arranjos e colocando sua personalidade. O seu repertório tem tudo a ver com os seus integrantes já que, foram criados ouvindo essas músicas, o que inclui Djavan, Ivan Lins, Luis Melodia, Tom Jobim, Zeca Pagodinho, entre outros. '," +
                " 0, 0, 0, 2)"); // 5

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Thiago Alves & Pierre'," +
                "'MPB...', " +
                "'A dupla se conhecia de eventos regionais, exposições, feiras e festivais, porém estavam sempre em lados um pouco distantes musicalmente. Thiago Alves é músico de formação católica e desde sempre muito eclético, tocou em banda de baile, serestas e passou por várias bandas, com pequena preferência para o Rock Nacional, Mpb e Regional, por influências destes projetos, mas desde sempre muito aberto a novos sons e experiências, com grande capacidade de absorver conteúdo e repertório. Pierre Pureza não nega a origem sambista, tanto que até hoje, nas horas vagas, cada vez menores, participa de projetos ligados a samba e pagode. Com o surgimento das oportunidades em casas de shows adaptadas ao publico da região, barzinhos e festas, a dupla viu oportunidade de criar o projeto para atender esta demanda e apesar de terem trabalhado juntos em outros projetos, Thiago Alves e Pierre, desde Fevereiro de 2015, assumiram essa marca que vem crescendo graças à humildade musical, respeito aos contratantes e publico e capacidade de adaptar o repertório para cada tipo de evento e espectadores.'," +
                " 0, 0, 0, 2)"); // 6

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Leonardo de Freitas e Fabiano'," +
                "'Sertanejo Universitário...', " +
                "'A dupla Leonardo de Freitas e Fabiano, iniciou sua trajetória em meados de 2005 na cidade de Juiz de Fora (MG). Em pouco tempo cativaram um publico em seus shows, tornando-se referencia na região. Rapidamente foram convidados para dividir o palco com grandes nomes da musica sertaneja, como Daniel, Jorge e Matheus, João Bosco e Vinicius, Bruno e Marrone, Michel Teló, Guilherme e Santiago e outros. Com isso ganharam notoriedade no cenário musical.\n" +
                " \n" +
                "Os números mostram. Em 9 anos de carreira, são 2 CDs e 1 DVD gravados, 190 shows no ano, mais de 1 milhão de visualizações na internet. Recentemente gravaram o CLIP da musica “Coração pede socorro” no Castelo de Itaipava (RJ) tornando sucesso imediato. Participaram do quadro “Jogo de Panela” no programa da Ana Maria Braga (TV Globo), além de se apresentarem em eventos no Copacabana Palace, conquistando fãs cariocas.\n" +
                " \n" +
                "Um novo CD e DVD com grandes participações em um repertorio baseado no clássico do sertanejo, são algumas das novidades da dupla para o ano de 2014.\n" +
                " \n" +
                "Leonardo de Freitas: cantor, compositor, arranjador e musico multi-instrumentista (teclado, baixo, guitarra, violão, bateria, viola e acordeon). Dono de um talento admirável.\n" +
                " \n" +
                "Fabiano: cantor, musico (Violão e Guitarra). Extremamente focado na carreira, o sucesso é seu objetivo. '," +
                " 0, 0, 0, 2)"); // 7

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Larissa Viana e Julien'," +
                "'Bossa Nova e MPB...', " +
                "' '," +
                " 0, 0, 0, 2)"); // 8

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Rafael Santos'," +
                "'Sertanejo Universitário...', " +
                "' '," +
                " 0, 0, 0, 2)"); // 9

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Acústico A3'," +
                "'MPB, Reggae, Pop Rock...', " +
                "'A Banda AC 3 surgiu no fim de 2008, na cidade de Três Rios /RJ, com os músicos Gustavo Cunha, (Voz e Violão), Tiago Cunha (Bateria) e Juninho Hiote (Baixo). Desde então, a banda mescla estilos como MPB, pop/rock, reggae nacional, sertanejo universitário, entre outros; contudo, busca sempre inovações musicais a fim de atender a todos os gostos e a todos que acompanham suas apresentações em sua curta carreira musical. \n" +
                "\n" +
                "Sucesso por onde tocam, vêm deixando sempre sua marca nos bares e festas da região com suas duas principais músicas, frutos do primeiro CD da banda: Fico a Imaginar e Anjo Sol, ambas compostas por eles mesmos e que definem exatamente o espírito do show: alegria e espontaneidade. As duas canções concorreram ao Festival Antense da Canção, no qual a banda ficou em segundo lugar com a música Fico a Imaginar, que posteriormente passou a ser reproduzida na FM 107,3, tal qual Anjo Sol. \n" +
                "\n" +
                "Apesar de jovens, os integrantes são músicos experientes e já participaram de diversos grupos musicais de estilos bem variados, e usam em seus shows o conhecimento adquirido em suas carreiras para divertir e conquistar o público de diferentes idades e gosto musical. \n" +
                "\n" +
                "A banda já abriu shows de artistas como Michel Teló, Os Travessos, Gustavo Lins, entre outros. E se apresentou em diversas festas e exposições das cidades da região, como Três Rios, Paraíba do Sul, Sapucaia, Areal, Levy Gasparian, Juiz de Fora e Cabo Frio, sempre com o lema: ”Se divertir para divertir”.'," +
                " 0, 0, 0, 2)"); // 10

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Banda Replay'," +
                "'Flashback...', " +
                "'Criada em março de 2008, a Banda Replay trouxe   um toque diferente que tem encantado e esquentado as noites do Rio. Com shows e repertório que fogem dos tradicionais apresentados por outras bandas de flashback, a banda toca músicas dos anos 70, 80 e 90 que você adorava e há muito tempo não ouvia, além daquelas que você escuta sempre e quer ouvir de novo.\n" +
                " \n" +
                "Misturando artistas como Erasure e Michael Jackson, Pet Shop Boys e Leo Jaime, Gloria Estefan e Lulu Santos, Metro e Legião Urbana a Replay faz performances com muita energia e carisma, fazendo ferver qualquer pista de dança. Esta diversidade, associada à parceria com a empresa GIG Audio, responsável pela infraestrutura técnica impecável de som e iluminação que acompanha a banda, cria um espetáculo que vai tornar sua festa inesquecível. \n" +
                "  \n" +
                "A Replay é tudo que você espera para seu evento e muito mais, confira!'," +
                " 0, 0, 0, 2)"); // 11

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Sebrae'," +
                "'O Serviço Brasileiro de Apoio às Micro e Pequenas Empresas (Sebrae) é uma entidade privada que promove a competitividade.....', " +
                "'O Serviço Brasileiro de Apoio às Micro e Pequenas Empresas (Sebrae) é uma entidade privada que promove a competitividade e o desenvolvimento sustentável dos empreendimentos de micro e pequeno porte – aqueles com faturamento bruto anual de até R$ 3,6 milhões.\n" +
                "\n" +
                "Há mais de 40 anos, atua com foco no fortalecimento do empreendedorismo e na aceleração do processo de formalização da economia por meio de parcerias com os setores público e privado, programas de capacitação, acesso ao crédito e à inovação, estímulo ao associativismo, feiras e rodadas de negócios.\n" +
                "\n" +
                "As soluções desenvolvidas pelo Sebrae atendem desde o empreendedor que pretende abrir seu primeiro negócio até pequenas empresas que já estão consolidadas e buscam um novo posicionamento no mercado.\n" +
                "\n" +
                "Para garantir o atendimento aos pequenos negócios, o Sebrae atua em todo o território nacional. Onde tem Brasil, tem Sebrae. Além da sede nacional, em Brasília, a instituição conta com pontos de atendimento nas 27 Unidades da Federação, onde são oferecidos cursos, seminários, consultorias e assistência técnica para pequenos negócios de todos os setores.'," +
                " 1, 0, 1, 6)"); // 12

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Sicomércio'," +
                "'O Sicomércio Três Rios - Sindicato do Comércio Varejista de Três Rios, Paraíba do Sul, Areal, Comendador Levy Gasparian é uma entidade patronal nascida...', " +
                "'O Sicomércio Três Rios - Sindicato do Comércio Varejista de Três Rios, Paraíba do Sul, Areal, Comendador Levy Gasparian é uma entidade patronal nascida em 14/03/1985, do desejo de um grupo de empresários, que via na UNIÃO, uma forma de organizar seus negócios e poder ter voz ativa, perante os diversos órgãos. \n" +
                "\n" +
                "Ao longo desses anos o Sicomércio Três Rios, cresceu e para atender aos anseios e necessidades do segmento que representa, o Sicomércio atua de forma impactante no aprimoramento dos negócios, pois acredita na atitude positiva que irá transformar a relação de produção e consumo na região. A proposta é dar voz aos associados frente à sociedade, construindo um setor respeitado e influente nas decisões políticas e econômicas ao gerar bons serviços, equilíbrio nas vendas e interação com a comunidade e o poder público.'," +
                " 1, 1, 1, 3)"); // 13

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('CVT Três Rios'," +
                "'Centro Vocacional Tecnológico...', " +
                "'  '," +
                " 0, 0, 0, 1)"); // 14

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Bruno Lemos'," +
                "'Professor USS...', " +
                "'  '," +
                " 0, 0, 0, 5)"); // 15

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('IFRJ - Campus Eng. Paulo de Frontin'," +
                "'Curso Superior de Tecnologia em Jogos Digitais...', " +
                "'O Campus Engenheiro Paulo de Frontin é um dos atuais 11 campi do IFRJ, localizado na região centro-sul fluminense, no município de Engenheiro Paulo de Frontin, mais precisamente no distrito de Sacra Família do Tinguá.  O Campus encontra-se entre as cidades de São Paulo (SP) e Macaé (RJ), a 27 km do Arco metropolitano do Rio de Janeiro, a 34,4 km da Rodovia Presidente Dutra (BR 116) e a 104 km da capital.  Está situado na região Centro Sul do Estado do Rio de Janeiro – Serra do Mar.\n" +
                "\n" +
                "A inauguração do campus se deu em Brasília no dia 1 de fevereiro de 2010 e contou com a presença do então reitor do IFRJ Prof. Dr. Luiz Edmundo Vargas de Aguiar, a atual Presidenta da República Dilma Rousseff, o então presidente da república Luiz Inácio Lula da Silva, o primeiro diretor Prof. Dr. Rodney Cezar de Albuquerque e o então prefeito do município de Eng. Paulo de Frontin, Eduardo Ramos da Paixão.\n" +
                "\n" +
                "No início de 2011 iniciou-se a oferta do primeiro curso técnico do campus, Informática para Internet, funcionando na modalidade concomitante e subseqüente no turno vespertino. O objetivo principal deste curso é o de tornar o aluno capaz de aprender a desenvolver programas de computador voltados para a internet e outras redes de computadores, seguindo as especificações e paradigmas da lógica de programação e das linguagens mais avançadas do mercado. Além disso, são apresentadas ao aluno diversas metodologias, lógica de programação e ferramentas de desenvolvimento de sistemas, para construir soluções que auxiliem no processo de criação de interfaces e aplicativos empregados no comércio e marketing eletrônicos.'," +
                " 0, 0, 0, 5)"); // 16

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Gustavo Guanabara'," +
                "'Professor...', " +
                "'  '," +
                " 0, 0, 0, 5)"); // 17

        try {
            dateEventoGuto = mFormatter.parse(sdateEventoGuto);

            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL +") VALUES('Comunicação Eficaz em Tempos de Crise'," +
                    "'Mudança de atitude perante as dificuldades encontradas através da comunicação eficaz.', " +
                    "'Mudança de atitude perante as dificuldades encontradas através da comunicação eficaz; Novas estratégias para aperfeiçoar a comunicação e enfrentar as adversidades no momento de crise; Aperfeiçoar a comunicação com público interno e clientes para obtenção de resultados.'," +
                    dateEventoGuto.getTime() + ", 1, 1, 30, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoRodrigo = mFormatter.parse(sdateEventoRodrigo);

            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Construindo uma Tropa de Elite'," +
                    "'...despertar as pessoas para superar os “desafios” do ambiente competitivo de trabalho...', " +
                    "'A palestra tem como objetivo despertar as pessoas para superar os “desafios” do ambiente competitivo de trabalho e para focar a liderança sob o aspecto dos “homens de preto” do BOPE.'," +
                    dateEventoRodrigo.getTime() + ", 1, 2, 30, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoBel = mFormatter.parse(sdateEventoBel);

            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Uma Jornada Empreendedora'," +
                    "'Na palestra, Bel Pesce conta, com muita leveza e humor, sua extraordinária trajetória de carreira.', " +
                    "'Na palestra, Bel Pesce conta, com muita leveza e humor, sua extraordinária trajetória de carreira. Cada vitória é cheia de obstáculos, que Bel consegue atravessar, usando atitudes empreendedoras e  ideias inovadoras. Através de várias histórias envolventes, ela mostra como humildade, gentileza, perseverança, e determinação foram fatores importantes para seu sucesso.'," +
                    dateEventoBel.getTime() + ", 1, 3, 30, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoRey = mFormatter.parse(sdateEventoRey);

            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Obtendo Sucesso, Cuidando da Saúde, Bem Estar e Beleza'," +
                    "'A palestra tem como foco: motivação, autoestima, beleza, estética...', " +
                    "'A palestra tem como foco: motivação, autoestima, beleza, estética, comportamento, nutrição, estilo de vida e cirurgia - A importância de homens e mulheres em estar bem com o corpo e mente, como forma  de obtenção de sucesso na vida pessoal e profissional.'," +
                    dateEventoRey.getTime() + ", 1, 4, 30, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoMisturaFina = mFormatter.parse(sdateEventoMisturaFina);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Show com Mistura Fina'," +
                    "'MPB', " +
                    "'A banda Mistura Fina pretende fazer um show temático trazendo à tona a história das músicas que estão tocando.'," +
                    dateEventoMisturaFina.getTime() + ", 2, 5, 60, 'Palco MPB')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoThiagoPierre = mFormatter.parse(sdateEventoThiagoPierre);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Show com Thiago Alves & Pierre'," +
                    "'MPB', " +
                    "'Em especial para o centro Sul Negócios a dupla preparou um repertório focado na musica regional e Mpb, mas também com passagens criativas pelo Reggae, Xote, Samba e Rock Nacional. Mesmo com o Setlist em mãos cada apresentação é uma viagem diferente, pois a dupla sempre deseja corresponder aos olhares e ao cantar do público e por isso com Thiago Alves, vocalista sempre atento a isso e com vasto recurso de repertório e Pierre, percussionista sempre inquieto e atento, tudo pode acontecer.'," +
                    dateEventoThiagoPierre.getTime() + ", 2, 6, 60, 'Palco MPB')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoLeonardoFabiano = mFormatter.parse(sdateEventoLeonardoFabiano);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Show com Leonardo de Freitas e Fabiano'," +
                    "'Sertanejo Universitário', " +
                    "'    '," +
                    dateEventoLeonardoFabiano.getTime() + ", 2, 7, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoLarissaJulien = mFormatter.parse(sdateEventoLarissaJulien);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Show com Larissa Viana e Julien'," +
                    "'Bossa Nova e MPB', " +
                    "'    '," +
                    dateEventoLarissaJulien.getTime() + ", 2, 8, 60, 'Palco MPB')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoRafaelSantos = mFormatter.parse(sdateEventoRafaelSantos);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Show com Rafael Santos'," +
                    "'Sertanejo Universitário', " +
                    "'    '," +
                    dateEventoRafaelSantos.getTime() + ", 2, 9, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoAcustico = mFormatter.parse(sdateEventoAcustico);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Show com Acústico A3'," +
                    "'MPB, Reggae, Pop Rock', " +
                    "'O Acústico A3 promete mostrar toda sua versatilidade musical em um show empolgante e diferente no próximo sábado. A banda que já é conhecida na região por se apresentar de forma irreverente misturando vários estilos musicais, trará para o público um show eclético recheado de músicas atuais com outras que marcaram época com versões criadas pelos próprios músicos. É um show para todas as gerações curtirem e relembrarem grandes sucessos da música nacional e internacional.'," +
                    dateEventoAcustico.getTime() + ", 2, 10, 60, 'Palco MPB')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoReplay = mFormatter.parse(sdateEventoReplay);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Show com Banda Replay'," +
                    "'Flashback', " +
                    "'    '," +
                    dateEventoReplay.getTime() + ", 2, 11, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoSebraeRodadaCredito = mFormatter.parse(sdateEventoSebraeRodadaCredito);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Sessão de Negócios e Rodada de Crédito'," +
                    "'Sebrae', " +
                    "'    '," +
                    dateEventoSebraeRodadaCredito.getTime() + ", 1, 12, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoSebraeMei = mFormatter.parse(sdateEventoSebraeMei);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Finanças Pessoais MEI, Empreendedores e Empresários'," +
                    "'Sebrae', " +
                    "'    '," +
                    dateEventoSebraeMei.getTime() + ", 1, 12, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoSebraeDinheiroInovacao = mFormatter.parse(sdateEventoSebraeDinheiroInovacao);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Finanças Pessoais MEI, Empreendedores e Empresários'," +
                    "'Sebrae/Sicomércio', " +
                    "'    '," +
                    dateEventoSebraeDinheiroInovacao.getTime() + ", 3, 12, 60, 'Auditório do Salão Nobre')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoSebraeEmpreendedorismo = mFormatter.parse(sdateEventoSebraeEmpreendedorismo);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Empreendedorismo e as oportunidades do mercado'," +
                    "'Sebrae', " +
                    "'    '," +
                    dateEventoSebraeEmpreendedorismo.getTime() + ", 1, 12, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoSebraeNegociacaoEmpresarial = mFormatter.parse(sdateEventoSebraeNegociacaoEmpresarial);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Negociação Empresarial - formando alianças e parcerias'," +
                    "'Sebrae/Sicomércio', " +
                    "'    '," +
                    dateEventoSebraeNegociacaoEmpresarial.getTime() + ", 3, 12, 60, 'Auditório do Salão Nobre')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoSebraeConstruindoIdentidade = mFormatter.parse(sdateEventoSebraeConstruindoIdentidade);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Construindo a identidade da sua empresa'," +
                    "'Sebrae/Sicomércio', " +
                    "'    '," +
                    dateEventoSebraeConstruindoIdentidade.getTime() + ", 3, 12, 60, 'Auditório do Salão Nobre')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoSebraeRedesSociais = mFormatter.parse(sdateEventoSebraeRedesSociais);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Utilizando as Redes Sociais para aumentar seus clientes'," +
                    "'Sebrae/Sicomércio', " +
                    "'    '," +
                    dateEventoSebraeRedesSociais.getTime() + ", 3, 12, 60, 'Auditório do Salão Nobre')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoSebraeStarupRJ = mFormatter.parse(sdateEventoSebraeStarupRJ);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Programa Sebrae StartupRJ - Conhecendo as oportunidades'," +
                    "'Sebrae', " +
                    "'    '," +
                    dateEventoSebraeStarupRJ.getTime() + ", 1, 12, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }


        try {
            dateEventoMostraProjetosTecnologicos = mFormatter.parse(sdateEventoMostraProjetosTecnologicos);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Mostra de Projetos Tecnológicos'," +
                    "'CVT Três Rios', " +
                    "'    '," +
                    dateEventoMostraProjetosTecnologicos.getTime() + ", 3, 14, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoEngenheiroComputacao = mFormatter.parse(sdateEventoEngenheiroComputacao);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('O Engenheiro de Computação e o cenário profissional'," +
                    "'Prof. Bruno Lemos - USS', " +
                    "'    '," +
                    dateEventoEngenheiroComputacao.getTime() + ", 1, 15, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoMostraJogos = mFormatter.parse(sdateEventoMostraJogos);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Mostra de Jogos Digitais'," +
                    "'Curso Superior de Tecnologia em Jogos Digitais - IFRJ - Campus Eng. Paulo de Frontin', " +
                    "'O design curricular do curso de Jogos Digitais do IFRJ em Eng. Paulo de Frontin foi minuciosamente planejado mediante realização de audiências públicas, visitas a universidades que disponibilizam o curso e intenso diálogo com os segmentos produtivos. Cada um dos seis períodos letivos será centrado em uma temática: Jogos em 2D, Jogos em 3D, Jogos em Rede, Jogos para Consoles, Jogos para Dispositivos Móveis e Jogos para TV Digital. Ao final do curso o estudante será diplomado Tecnólogo em Jogos Digitais, estando apto a prosseguir seus estudos em nível de pós-graduação e a ingressar no mercado de trabalho em diferentes segmentos da economia, atuando principalmente como Programador de Jogos Digitais, Game Designer, Artista Gráfico ou, ainda, Músico Digital.'," +
                    dateEventoMostraJogos.getTime() + ", 3, 16, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEvento50dicas = mFormatter.parse(sdateEvento50dicas);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('50 dicas para destruir sua carreira usando Redes Sociais'," +
                    "'Com Prof. Gustavo Guanabara', " +
                    "'    '," +
                    dateEvento50dicas.getTime() + ", 1, 17, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CategoriaEventoDao.DROP_TABLE);
        db.execSQL(CategoriaColaboradorDao.DROP_TABLE);
        db.execSQL(ColaboradorDao.DROP_TABLE);
        db.execSQL(EventoDao.DROP_TABLE);
        db.execSQL(ConfiguracaoDao.DROP_TABLE);
        onCreate(db);
    }
}
