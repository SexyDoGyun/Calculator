package lv3;

public class Options {

    private final ResultRepository<Number> resultRepository;

    public Options(ResultRepository<Number> resultRepository) {
        this.resultRepository = resultRepository;
    }

    // 저장 되어있는 결과 출력
    public void showResult() {
            System.out.println("저장된 결과들: " + resultRepository.findAll());
    }

    // 결과 삭제
    public void deleteOldest() {
            resultRepository.deleteOldest();
            System.out.println("삭제 후 결과들: " + resultRepository.findAll());
    }

    // 특정값 보다 큰 값 조회
    public void showBigger(double number) {
            System.out.println("특정 값 보다 큰 값: " + resultRepository.findBigger(number));
    }


}
