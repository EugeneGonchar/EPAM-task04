package com.epam.task04.dao.xml;

import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.task04.entity.node.Attribute;
import com.epam.task04.entity.node.CloseTag;
import com.epam.task04.entity.node.Content;
import com.epam.task04.entity.node.EmptyBodyTag;
import com.epam.task04.entity.node.Node;
import com.epam.task04.entity.node.OpenTag;

public class XmlLineParser {
	private final static String SPACE_SYMBOLS_STRING = "^[\\s]*$";
	private final static String OPEN_TAG = "<\\??[^<>{}\\[\\]\\(\\)\\/]+>";
	private final static String CLOSE_TAG = "<\\/[^<>{}\\[\\]\\(\\)\\/]+>";
	private final static String CONTENT = "^[^</?][A-Za-zА-Яа-я0-9_.-:+\\s]*[^/>]$";
	private final static String EMPTY_BODY_TAG = "<[^<>{}\\[\\]\\(\\)\\/]+\\/>";
	private final static String SEVERAL_WHITESPACES = "[\\s]+";
	private final static String WHITESPACE = "^\\s";
	private final static String TRAILING_SPACE = "\\s$";
	private final static String TAG_NAME = "<\\??\\/?\\s*([A-Za-zА-Яа-я0-9_-]+).*\\/?>";
	private final static String ATTRIBUTES = "((?:[A-Za-zА-Яа-я0-9_-])+\\s*\\=\\s*\\\"(?:[A-Za-zА-Яа-я0-9_.-])+)\\\"";
	private final static String ATTRIBUTE_NAME = "^[A-Za-zА-Яа-я0-9_-]+";
	private final static String ATTRIBUTE_VALUE = "\\\"\\s*([A-Za-zА-Яа-я0-9-_+.:]+)\\s*\\\"";
	
	private String line;
	Node node;
	
	public XmlLineParser() {}
	
	public XmlLineParser(String line) {
		this.line = line;
	}
	
	public static boolean isSpaces(StringBuilder line) {
		Matcher matcher = Pattern.compile(SPACE_SYMBOLS_STRING).matcher(line);
		if(matcher.matches())
			return true;
		return false;
	}
	
	public boolean isConcreteTag(String tagRegEx) {
		Matcher matcher = Pattern.compile(tagRegEx).matcher(line);
		if(matcher.matches())
			return true;
		return false;
	}
	
	public void deleteTokens() {
    	line = line.replaceAll(SEVERAL_WHITESPACES, " ");
    	line = line.replaceAll(WHITESPACE, "");
    	line = line.replaceAll(TRAILING_SPACE, "");
	}
	
	public String getTagName() {
		deleteTokens();
		String tagName = null;
		Matcher matcher = Pattern.compile(TAG_NAME).matcher(line);
		while(matcher.find())
			tagName = matcher.group(1);
		return tagName;
	}
	
	public List<String> getAttributeList() {
		deleteTokens();
		List<String> attributes = new LinkedList<String>();
		Matcher matcher = Pattern.compile(ATTRIBUTES).matcher(line);
		while(matcher.find()) {
			attributes.add(matcher.group());
		}
		return attributes;
	}
	
	public String getAttributeName(String line) {
		deleteTokens();
		String attributeName = null;
		Matcher matcher = Pattern.compile(ATTRIBUTE_NAME).matcher(line);
		while(matcher.find())
			attributeName = matcher.group();
		return attributeName;
	}
	
	public String getAttributeValue(String line) {
		deleteTokens();
		String attributeValue = null;
		Matcher matcher = Pattern.compile(ATTRIBUTE_VALUE).matcher(line);
		while(matcher.find())
			attributeValue = matcher.group(1);
		return attributeValue;
	}
	
	public List<Attribute> stringAttributes2AttributeList(List<String> attributes){
		if(attributes.isEmpty())
			return null;
		Iterator<String> iterator = attributes.iterator();
		List<Attribute> attributesList = new LinkedList<Attribute>();
		
		while(iterator.hasNext()) {
			String attributeString = (String)iterator.next();
			Attribute attributeObject = new Attribute(getAttributeName(attributeString), getAttributeValue(attributeString));
			attributesList.add(attributeObject);
		}
		return attributesList;
	}
	
	public String getContent() {
		deleteTokens();
		return line;
	}


	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public Node getNode() {
		return node;
	}

	public void setNode() {
		if(isConcreteTag(OPEN_TAG)) {
			OpenTag openTag = new OpenTag();
			openTag.setName(getTagName());
			openTag.setAttributes(stringAttributes2AttributeList(getAttributeList()));
			node = openTag;
		}
		if(isConcreteTag(CLOSE_TAG)) {
			CloseTag closeTag = new CloseTag();
			closeTag.setName(getTagName());
			node = closeTag;
		}
		if(isConcreteTag(EMPTY_BODY_TAG)) {
			EmptyBodyTag emptyBodyTag = new EmptyBodyTag();
			emptyBodyTag.setName(getTagName());
			node = emptyBodyTag;
		}
		if(isConcreteTag(CONTENT)) {
			Content content = new Content();
			content.setContent(getContent());
			node = content;
		}
	}
}
