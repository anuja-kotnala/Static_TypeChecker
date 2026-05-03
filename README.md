This is a static type checker for a small language ( a subse of java);
Grammar rule are defined via if else blocks.
Currently supported data types:int, float, String.
Includes the following functionalities:

Declaration Checks:
1. ✓ Empty input validation
2. ✓ Valid datatype keywords (int, float, String)
3. ✓ Invalid datatype error (unrecognized types)
4. ✓ Valid declaration format (type variable;)
5. ✓ Multiple spaces handling (e.g., int a;)
6. ✓ Non-empty variable names
7. ✓ Duplicate variable declaration (variable already declared)

Assignment Checks:
8. ✓ Valid assignment format (must contain =)
9. ✓ Non-empty left-hand side (variable name)
10. ✓ Non-empty right-hand side (value or variable)
11. ✓ Left-hand side variable must be declared
12. ✓ Right-hand side variable must be declared (if not a literal)
13. ✓ Type inference for literals (123 → int, 3.14 → float, "text" → String)

Type Compatibility Checks:
14. ✓ Exact type matching (e.g., int = int ✓)
15. ✓ Implicit conversion (e.g., float = int ✓, but int = float ✗)
16. ✓ Incompatible type assignment detection
17. ✓ Null type safety