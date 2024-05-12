package decorator;

import strategy.ActionStrategy;
import factory.Entity;

/* Decorador base de Decorator: Referencia al objeto envuelto y delega
 * todas las operaciones a ese. No altera ningún comportamiento sino que proporciona
 * infraestructura para que los decoradores concretos añadan o modifiquen comportamientos. */
public class ActionDecorator extends ActionStrategy {
        
        private ActionStrategy actionStrategy;
        
        public ActionDecorator(ActionStrategy actionStrategy) {
            super(actionStrategy.getCurrentEntity());
            this.actionStrategy = actionStrategy;
        }
    
        @Override
        public void action(Entity target) {
            // Modifica la accion original
            actionStrategy.action(target);
        }
}
