package br.com.projuris.challengealgorithm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.projuris.challengealgorithm.servicesimpl.MyFindChar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyFindCharTest {

	@Test
	public void test() {
		MyFindChar.findChar("teste");
	}
}
