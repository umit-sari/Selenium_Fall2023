package practice;

import org.junit.*;

public class P02 {

    @BeforeClass
    public static void beforeClass() {

        System.out.println("@Before Class: Before Class calisti testler calismaya baslayabilir");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("@AfterClass:Tum testler basariyla tamamlandi");
    }

    @Before
    public void setUp() {
        System.out.println(" @Before: Yeni bir test kodu calistiriliyor");
    }

    @After
    public void teardown() {
        System.out.println("@After:Bu test tamamlandi.Siradaki test calistiralacak");
    }

    @Test
    public void test01() {
        System.out.println("01 nolu test calistirildi");
    }

    @Test
    public void test02() {
        System.out.println("02 nolu test calistirildi");
    }

}
