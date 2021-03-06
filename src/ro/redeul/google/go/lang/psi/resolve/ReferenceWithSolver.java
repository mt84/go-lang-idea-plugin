package ro.redeul.google.go.lang.psi.resolve;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ro.redeul.google.go.lang.psi.GoPsiElement;

public abstract class ReferenceWithSolver<
        E extends GoPsiElement,
        S extends ReferenceSolver<R, S>,
        R extends ReferenceWithSolver<E, S, R>
        > extends Reference<E, R> {

    public ReferenceWithSolver(E element) {
        super(element);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E getElement() {
        return (E)super.getElement();
    }

    protected abstract S newSolver();

    protected abstract void walkSolver(S solver);

    @Nullable
    @Override
    public PsiElement resolve() {
        return newSolver().resolve(self());
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return newSolver().getVariants(self());
    }
}
