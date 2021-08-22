package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class consultaCurso {
    private WebDriver driver;

    @Before
    public void inciar(){
        System.setProperty("webdriver.chrome.driver", "driver/chrome/92/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MICROSECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void finalizar(){
        driver.quit();
    }

    @Dado("^que acesso o site da iterasys$")
    public void queAcessoOSiteDaIterasys() {
        driver.get("https://iterasys.com.br/");
        System.out.println("Passo 1 - Acessar o site.");
    }

    @Quando("^preencho a consulta com \"([^\"]*)\"$")
    public void preenchoAConsultaCom(String curso) {
        driver.findElement(By.id("searchtext")).click();
        driver.findElement(By.id("searchtext")).clear();
        driver.findElement(By.id("searchtext")).sendKeys(curso);
        System.out.println("Parte 2 - Consultar o curso.");
    }

    @E("^clico na lupa$")
    public void clicoNaLupa() {
        driver.findElement(By.id("btn_form_search")).click();
        System.out.println("Parte 3 - Clicar na lupa.");
    }

    @Entao("^visualizo a oferta do curso \"([^\"]*)\"$")
    public void visualizoAOfertaDoCurso(String curso) {
        assertEquals("Cursos › \"" + curso + "\"", driver.findElement(By.cssSelector("h3")).getText());
        System.out.println("Parte 4 - Ver o curso.");
    }

    @Quando("^clico em Matricular-se no curso$")
    public void clicoEmMatricularSeNoCurso() {
        driver.findElement(By.cssSelector("span.comprar")).click();
        System.out.println("Parte 5 - Clicar em Matricule-se");
    }

    @Entao("^visualizo curso \"([^\"]*)\" no carrinho e seu valor de \"([^\"]*)\"$")
    public void visualizoCursoNoCarrinhoESeuValorDe(String curso, String preco) {
        assertEquals(curso, driver.findElement(By.cssSelector("span.item-title")).getText());
        assertEquals(preco, driver.findElement(By.cssSelector("div.subtotal")).getText());
        System.out.println("Parte 6 - Confirmo o curso e preço.");
    }
}
