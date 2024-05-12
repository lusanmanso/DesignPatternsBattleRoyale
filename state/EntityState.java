package state;

import factory.*;

public interface EntityState {
    void applyEffect(Entity entity);
    void updateState(Entity entity);
}