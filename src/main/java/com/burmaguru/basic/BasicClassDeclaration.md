## Notes: 
    
Without public access modifier is the default public in java

### Equality (`equals`) and Hash Code (`hashCode`) Overview

1. **`equals(Object obj)`**:
    - **Purpose**: Determines if two objects are considered equal.
    - **Contract**:
        - If `a.equals(b)` is `true`, then `a.hashCode() == b.hashCode()` must also be `true`.
        - Should handle `null` and type checks.

2. **`hashCode()`**:
    - **Purpose**: Returns an integer hash code for the object.
    - **Usage**: Optimizes storage and retrieval in hash-based collections (e.g., `HashMap`, `HashSet`).
    - **Contract**:
        - If two objects are equal, they must return the same hash code.
        - Unequal objects can have the same hash code (but it's best to minimize this).

### Example Implementation

```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return age == person.age && Objects.equals(name, person.name);
}

@Override
public int hashCode() {
    return Objects.hash(age, name);
}
```

### Summary
- **`equals`** checks for logical equality.
- **`hashCode`** ensures efficient storage and retrieval in hash-based collections while adhering to the equality contract.