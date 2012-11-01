public abstract class AbstractKeytermExtractor extends AbstractLoggedComponent {

	protected abstract List<Keyterm> getKeyterms(String question);

	@Override
	public final void process(JCas jcas) throws AnalysisEngineProcessException {
		super.process(jcas);
		try {
			// prepare input
			InputElement input =
			    (InputElement) BaseJCasHelper.getAnnotation(jcas, InputElement.type);
			String question = input.getQuestion();
			// do task
			List<Keyterm> keyterms = getKeyterms(question);
			log(keyterms.toString());
			// save output
			KeytermList.storeKeyterms(jcas, keyterms);
		} catch (Exception e) {
			throw new AnalysisEngineProcessException(e);
		}
	}

	protected final void log(String message) {
		super.log(QALogEntry.KEYTERM, message);
	}

}