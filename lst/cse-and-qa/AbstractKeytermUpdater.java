public abstract class AbstractKeytermUpdater extends AbstractLoggedComponent {

	protected abstract List<Keyterm> updateKeyterms(String question,
	    List<Keyterm> keyterms);

	@Override
	public final void process(JCas jcas) throws AnalysisEngineProcessException {
		super.process(jcas);
		try {
			// prepare input
			String question =
			    ((InputElement) BaseJCasHelper.getAnnotation(jcas, InputElement.type))
			        .getQuestion();
			List<Keyterm> keyterms;
			keyterms = KeytermList.retrieveKeyterms(jcas);
			// do task
			keyterms = updateKeyterms(question, keyterms);
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
