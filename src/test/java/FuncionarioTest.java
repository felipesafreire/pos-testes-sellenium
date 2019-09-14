import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class FuncionarioTest {

    private final String BASE_URL = "http://192.168.5.115:9098/";
    private WebDriver driver;


    @Before
    public void iniciaSellenium() {

        System.setProperty("webdriver.chrome.driver", "C:\\Projetos\\chromedriver.exe");
        this.driver = new ChromeDriver();

    }

    @After
    public void encerraSellenium() {

        driver.close();

    }

    @Test
    public void deveAdicionarUmFuncionario() {

        String url = this.BASE_URL + "calculator/new";
        driver.get(url);

        WebElement nome = driver.findElement(By.id("name"));
        WebElement dependentes = driver.findElement(By.id("dependents"));
        WebElement horasTrabalhadas = driver.findElement(By.id("timeToWork"));
        WebElement salarioHora = driver.findElement(By.id("salaryHour"));

        dependentes.clear();
        horasTrabalhadas.clear();
        salarioHora.clear();

        nome.sendKeys("Teste Sellenium");
        dependentes.sendKeys("1");
        horasTrabalhadas.sendKeys("8");
        salarioHora.sendKeys("75.00");

        WebElement botaoSalvar = driver.findElement(By.id("salvar"));
        botaoSalvar.submit();


        boolean achouNome = driver.getPageSource().contains("Teste Sellenium");
        assertTrue(achouNome);

    }

    @Test
    public void deveTestarCadastroDoFuncionarioCamposObrigatorios() {

        String url = this.BASE_URL + "calculator/new";
        driver.get(url);

        WebElement nome = driver.findElement(By.id("name"));
        WebElement dependentes = driver.findElement(By.id("dependents"));
        WebElement horasTrabalhadas = driver.findElement(By.id("timeToWork"));
        WebElement salarioHora = driver.findElement(By.id("salaryHour"));

        dependentes.clear();
        horasTrabalhadas.clear();
        salarioHora.clear();

        nome.sendKeys("");
        dependentes.sendKeys("");
        horasTrabalhadas.sendKeys("");
        salarioHora.sendKeys("");

        WebElement botaoSalvar = driver.findElement(By.id("salvar"));
        botaoSalvar.submit();

        boolean nomeNaoPreenchido = driver.getPageSource().contains("não pode estar vazio");
        boolean camposHoras = driver.getPageSource().contains("deve ser maior ou igual a 1");


        assertTrue(!nomeNaoPreenchido);
        assertTrue(!camposHoras);

    }




}
