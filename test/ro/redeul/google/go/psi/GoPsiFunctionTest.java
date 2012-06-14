package ro.redeul.google.go.psi;

import ro.redeul.google.go.lang.psi.GoFile;
import ro.redeul.google.go.lang.psi.toplevel.GoFunctionDeclaration;
import static ro.redeul.google.go.util.GoPsiTestUtils.get;

public class GoPsiFunctionTest extends GoPsiTestCase {

    public void testNoParams() throws Exception {
        GoFile file = get(parse("package main; func a() { }"));
        GoFunctionDeclaration func = get(file.getFunctions(), 0);

        assertEquals(func.getParameters().length, 0);
    }

    public void testOneParam() throws Exception {
        GoFile file = get(parse("package main; func a(a int) { }"));
        GoFunctionDeclaration func = get(file.getFunctions(), 0);

        assertEquals(func.getParameters().length, 1);
    }

    public void testOneParamVariadic() throws Exception {
        GoFile file = get(parse("package main; func a(a ...int) { }"));
        GoFunctionDeclaration func = get(file.getFunctions(), 0);

        assertEquals(func.getParameters().length, 1);
    }
}