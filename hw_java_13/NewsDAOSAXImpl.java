
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl implements INewsDAO{
	List<News> list=new ArrayList<News>();
	@Override
	public List<News> getNewsList(String url) {
		connectNews(url);
		return list;
	}
	public News search(int index) {
		return list.get(index);
	}
	private void connectNews(String url){
		SAXParserFactory f=null;
		try{
			f=SAXParserFactory.newInstance();
			SAXParser p=f.newSAXParser();	
			p.parse(new URL(url).openConnection().getInputStream(), new SAXHandler());
		}catch(Exception e){
			System.out.println(e);
		}
	}	
	class SAXHandler  extends DefaultHandler{
		StringBuilder b= new StringBuilder();
		boolean flag=false;
		News n=null;
		
		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			if(qName.equalsIgnoreCase("item")){
				n=new News();
				flag=true;
			}
		}
		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			b.setLength(0);
			b.append(ch, start, length);			
		}
		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			if(flag && n!=null){
				switch(qName){
					case "title":
						n.setTitle(b.toString().trim());
						break;
					case "link":
						n.setLink(b.toString().trim());
						break;
					case "description":
						n.setDesc(b.toString().trim());
						break;
					case "item":
						list.add(n);
				}
			}
		}
		
	}
}
