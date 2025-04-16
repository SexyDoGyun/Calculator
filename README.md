# Calculator

# Git 컨벤션
feat: 새로운 기능 추가

fix: 버그 수정

refactor: 	코드 리팩토링 (기능 변화 없이 구조 개선)

docs: 문서 수정 (README, 주석 등)

chore: 기타 설정, 빌드, 패키지 등

### Lv 1. 클래스 없이 기본적인 연산을 수행할 수 있는 계산기 만들기

- **양의 정수(0 포함)를 입력받기**
    - Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.
    - 양의 정수는 각각 하나씩 전달 받습니다.
    - 양의 정수는 적합한 타입으로 선언한 변수에 저장합니다.
    - 예시 코드
        
        ```java
        public class lv1.App {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
        
                System.out.print("첫 번째 숫자를 입력하세요: ");
                // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
        		    System.out.print("두 번째 숫자를 입력하세요: ");
                // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            }
        }
        ```
        
- **사칙연산 기호(➕,➖,✖️,➗)를 입력받기**
    - Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
    - 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다. (`charAt(0)`)
    - 예시 코드
        
        ```java
        public class lv1.App {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                ...
                System.out.print("사칙연산 기호를 입력하세요: ");
                // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다. 
            }
        }
        ```
        
- **위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기**
    - 키워드 : `if` `switch`
    - 사칙연산 기호에 맞는 연산자를 사용하여 연산을 진행합니다.
    - 입력받은 연산 기호를 구분하기 위해 제어문을 사용합니다. (예를 들면 if, switch)
    - 연산 오류가 발생할 경우 해당 오류에 대한 내용을 정제하여 출력합니다.
        - ex) “나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.“
        - 예시 코드
            
            ```java
            public class lv1.App {
                public static void main(String[] args) {
                    Scanner sc = new Scanner(System.in);
                    ...
                    int result = 0;
                    /* 제어문을 활용하여 위 요구사항을 만족할 수 있게 구현합니다.*/
                    System.out.println("결과: " + result);
                }
            }
            ```
            
- **반복문을 사용하되, 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정하기**
    - 키워드 : 무한으로 반복, 수정하기 (처음부터 무한 반복하는 것이 아니라, 위 스텝별로 진행하며 수정)
    - 반복문을 사용합니다. (예를 들어, for, while…)
