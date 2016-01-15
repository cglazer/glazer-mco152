package glazer.NYPL;

public class Response {
	int numResults;
	Result[] result;
	Capture[] capture;

	public Capture[] getCapture() {
		return capture;
	}

	public void setCapture(Capture[] capture) {
		this.capture = capture;
	}

	public int getNumResults() {
		return numResults;
	}

	public void setNumResults(int numResults) {
		this.numResults = numResults;
	}

	public Result[] getResult() {
		return result;
	}

	public void setResult(Result[] result) {
		this.result = result;
	}
}
