package graphql.java.generator.type;

import java.util.HashMap;

import graphql.java.generator.strategies.AbstractStrategiesContainer;
import graphql.java.generator.strategies.Strategy;

public class TypeStrategies extends AbstractStrategiesContainer {
    public TypeNameStrategy getTypeNameStrategy() {
        return (TypeNameStrategy) allStrategies.get(TypeNameStrategy.class);
    }
    public TypeDescriptionStrategy getTypeDescriptionStrategy() {
        return (TypeDescriptionStrategy) allStrategies.get(TypeDescriptionStrategy.class);
    }
    public DefaultTypeStrategy getDefaultTypeStrategy() {
        return (DefaultTypeStrategy) allStrategies.get(DefaultTypeStrategy.class);
    }
    public EnumValuesStrategy getEnumValuesStrategy() {
        return (EnumValuesStrategy) allStrategies.get(EnumValuesStrategy.class);
    }
    public InterfacesStrategy getInterfacesStrategy() {
        return (InterfacesStrategy) allStrategies.get(InterfacesStrategy.class);
    }
    public TypeResolverStrategy getTypeResolverStrategy() {
        return (TypeResolverStrategy) allStrategies.get(TypeResolverStrategy.class);
    }
    
    public static class Builder {
        private HashMap<Class<? extends Strategy>, Strategy> strategies =
                new HashMap<Class<? extends Strategy>, Strategy>(); 
        
        public Builder typeNameStrategy(TypeNameStrategy typeNameStrategy) {
            strategies.put(TypeNameStrategy.class, typeNameStrategy);
            return this;
        }
        
        public Builder typeDescriptionStrategy(TypeDescriptionStrategy typeDescriptionStrategy) {
            strategies.put(TypeDescriptionStrategy.class, typeDescriptionStrategy);
            return this;
        }
        
        public Builder defaultTypeStrategy(DefaultTypeStrategy defaultTypeStrategy) {
            strategies.put(DefaultTypeStrategy.class, defaultTypeStrategy);
            return this;
        }
        
        public Builder enumValuesStrategy(EnumValuesStrategy enumValuesStrategy) {
            strategies.put(EnumValuesStrategy.class, enumValuesStrategy);
            return this;
        }
        
        public Builder interfacesStrategy(InterfacesStrategy interfacesStrategy) {
            strategies.put(InterfacesStrategy.class, interfacesStrategy);
            return this;
        }
        
        public Builder typeResolverStrategy(TypeResolverStrategy typeResolverStrategy) {
            strategies.put(TypeResolverStrategy.class, typeResolverStrategy);
            return this;
        }
        
        public Builder additionalStrategy(Strategy strategy) {
            strategies.put(strategy.getClass(), strategy);
            return this;
        }
        
        public TypeStrategies build() {
            return new TypeStrategies(this);
        }
    }
    
    private TypeStrategies(Builder builder) {
        allStrategies.putAll(builder.strategies);
    }
}
