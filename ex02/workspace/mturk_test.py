# this is a copy paste from: 
# https://blog.mturk.com/tutorial-a-beginners-guide-to-crowdsourcing-ml-training-data-with-python-and-mturk-d8df4bdf2977

import boto3

MTURK_SANDBOX = 'https://mturk-requester-sandbox.us-east-1.amazonaws.com'
# connect to sandbox
####################
mturk = boto3.client('mturk',
        aws_access_key_id = "PASTE_YOUR_IAM_USER_ACCESS_KEY",
        aws_secret_access_key = "PASTE_YOUR_IAM_USER_SECRET_KEY",
        region_name='us-east-1',
        endpoint_url = MTURK_SANDBOX
        )
# connect to live market place
##############################
# mturk = boto3.client('mturk',
#                       aws_access_key_id = "PASTE_YOUR_IAM_USER_ACCESS_KEY",
#                       aws_secret_access_key = "PASTE_YOUR_IAM_USER_SECRET_KEY",
#                       region_name='us-east-1'
#                   )

# print account balance
print "I have $" + mturk.get_account_balance()['AvailableBalance'] + " in my Sandbox account"

# define a HIT
##############
question = open(name='questions.xml',mode='r').read()
new_hit = mturk.create_hit(
        Title = 'Is this Tweet happy, angry, excited, scared, annoyed or upset?',
        Description = 'Read this tweet and type out one word to describe the emotion of the person posting it: happy, angry, scared, annoyed or upset',
        Keywords = 'text, quick, labeling',
        Reward = '0.15',
        MaxAssignments = 1,
        LifetimeInSeconds = 172800,
        AssignmentDurationInSeconds = 600,
        AutoApprovalDelayInSeconds = 14400,
        Question = question,
        )
print "A new HIT has been created. You can preview it here:"
print "https://workersandbox.mturk.com/mturk/preview?groupId=" + new_hit['HIT']['HITGroupId']
print "HITID = " + new_hit['HIT']['HITId'] + " (Use to Get Results)"
# Remember to modify the URL above when you're publishing
# HITs to the live marketplace.
# Use: https://worker.mturk.com/mturk/preview?groupId=

# get result 
############
# You will need the following library
# to help parse the XML answers supplied from MTurk
# Install it in your local environment with
# pip install xmltodict
import xmltodict
# Use the hit_id previously created
hit_id = 'PASTE_IN_YOUR_HIT_ID'
# We are only publishing this task to one Worker
# So we will get back an array with one item if it has been completed
worker_results = mturk.list_assignments_for_hit(HITId=hit_id, AssignmentStatuses=['Submitted'])
if worker_results['NumResults'] > 0:
    for assignment in worker_results['Assignments']:
        xml_doc = xmltodict.parse(assignment['Answer'])
        print "Worker's answer was:"
        if type(xml_doc['QuestionFormAnswers']['Answer']) is list:
            # Multiple fields in HIT layout
            for answer_field in xml_doc['QuestionFormAnswers']['Answer']:
                print "For input field: " + answer_field['QuestionIdentifier']
                print "Submitted answer: " + answer_field['FreeText']
        else:
            # One field found in HIT layout
            print "For input field: " + xml_doc['QuestionFormAnswers']['Answer']['QuestionIdentifier']
            print "Submitted answer: " + xml_doc['QuestionFormAnswers']['Answer']['FreeText']
else:
    print "No results ready yet"
