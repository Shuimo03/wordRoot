#utf-8
from scrapy import Request
from scrapy.spiders import Spider
from dictionary.items import DictionaryItem
class OxfordSpider(Spider):
    name = "oxford"
    def start_requests(self):
        url = 'https://www.oxfordlearnersdictionaries.com/wordlists/oxford3000-5000'
        yield Request(url = url)
    def parse(self,response):
        item = DictionaryItem()
        Oxford = response.xpath('//div[@class = "loaded"]/ul/li')
        for oxford in Oxford:
            item['word'] = oxford.xpath('/a/text()').extract_first()
            item['pos'] = oxford.xpath('/span/text()').extract_first()
            yield item

        # def parse(self,response):
        # item = DictionaryItem()
        # Oxford = response.xpath('//div[@class = "loaded"]/ul/li')
        # for oxford in Oxford:
        #     item['word'] = oxford.xpath('/a/text()').extract_first()
        #     item['pos'] = oxford.xpath('/span/text()').extract_first()
        #     yield