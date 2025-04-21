import os
from argparse import ArgumentParser
from typing import Dict, Literal, get_args

import requests
from bs4 import BeautifulSoup

langs = Literal["java", "scala", "cpp"]

templates: Dict[langs, str] = {
    "java": os.path.join("templates", "template.java"),
    "scala": os.path.join("templates", "template.scala"),
    "cpp": os.path.join("templates", "template.cpp"),
}

parser = ArgumentParser(
    description="script to setup a codeforces problem in any programming language"
)
parser.add_argument("contest_id", type=str, help="codeforces problem id")
parser.add_argument("problem")
parser.add_argument(
    "lang",
    type=str,
    choices=get_args(langs),
    help="language to setup proper template file",
)
args = parser.parse_args()

contest_id = args.contest_id
problem = args.problem
lang = args.lang

# https://codeforces.com/problemset/problem/1860/E
# https://codeforces.com/contest/1860/problem/E
problem_url = f"https://codeforces.com/problemset/problem/{contest_id}/{problem}"
html_text = requests.get(problem_url, timeout=10).text
soup = BeautifulSoup(html_text, "html.parser")

description = soup.select(".problem-statement > p")
input_specification = soup.select(".problem-statement > .input-specification > p").text
output_specification = soup.select(
    ".problem-statement > .output-specification > p"
).text
sample_tests = soup.select(".problem-statement > .sample-test")

print(input_specification)
print(output_specification)
